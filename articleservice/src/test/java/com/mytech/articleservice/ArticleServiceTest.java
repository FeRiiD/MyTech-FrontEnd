package com.mytech.articleservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ArticleServiceTest {

    @Mock
    private ArticleRepository repository;

    @InjectMocks
    private ArticleService articleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article());
        articles.add(new Article());
        when(repository.findAll()).thenReturn(articles);

        List<Article> result = articleService.getAllArticles();
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateArticle() throws ParseException {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = date.parse("2023-06-16");
        CreateArticleRequest request = new CreateArticleRequest(1,123,"Sample Article","Sample Content",creationDate);
        Article savedArticle = new Article();
        savedArticle.setArticleId(1);
        savedArticle.setUserId(123);
        savedArticle.setArticleTitle("Sample Article");
        savedArticle.setArticleContext("Sample Content");
        try {
            savedArticle.setCreationDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-06-16"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        when(repository.save(Mockito.any(Article.class))).thenReturn(savedArticle);

        Article result = articleService.createArticle(request);
        assertEquals(savedArticle, result);
    }
}
