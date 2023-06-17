package com.mytech.articleservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    private Article article;

    @BeforeEach
    void setUp() {
        article = new Article();
        System.out.println("Executing Article class tests");
    }

    @Test
    void setArticleId() {
        article.setArticleId(1);
        assertEquals(1, article.getArticleId());
    }

    @Test
    void setUserId() {
        article.setUserId(2);
        assertEquals(2, article.getUserId());
    }

    @Test
    void setArticleTitle() {
        String title = "Sample Title";
        article.setArticleTitle(title);
        assertEquals(title, article.getArticleTitle());
    }

    @Test
    void setArticleContext() {
        String context = "Sample Context";
        article.setArticleContext(context);
        assertEquals(context, article.getArticleContext());
    }

    @Test
    void setCreationDate() {
        Date date = new Date();
        article.setCreationDate(date);
        assertEquals(date, article.getCreationDate());
    }

    @Test
    void getArticleId() {
        article.setArticleId(3);
        assertEquals(3, article.getArticleId());
    }

    @Test
    void getUserId() {
        article.setUserId(4);
        assertEquals(4, article.getUserId());
    }

    @Test
    void getArticleTitle() {
        String title = "Sample Title";
        article.setArticleTitle(title);
        assertEquals(title, article.getArticleTitle());
    }

    @Test
    void getArticleContext() {
        String context = "Sample Context";
        article.setArticleContext(context);
        assertEquals(context, article.getArticleContext());
    }

    @Test
    void getCreationDate() {
        Date date = new Date();
        article.setCreationDate(date);
        assertEquals(date, article.getCreationDate());
    }

    @Test
    void testConstructor() {
        int expectedArticleId = 5;
        int expectedUserId = 6;
        String expectedTitle = "Sample Title";
        String expectedContext = "Sample Context";
        Date expectedDate = new Date();

        Article constructedArticle = new Article(
                expectedArticleId,
                expectedUserId,
                expectedTitle,
                expectedContext,
                expectedDate
        );

        assertEquals(expectedArticleId, constructedArticle.getArticleId());
        assertEquals(expectedUserId, constructedArticle.getUserId());
        assertEquals(expectedTitle, constructedArticle.getArticleTitle());
        assertEquals(expectedContext, constructedArticle.getArticleContext());
        assertEquals(expectedDate, constructedArticle.getCreationDate());
    }
}
