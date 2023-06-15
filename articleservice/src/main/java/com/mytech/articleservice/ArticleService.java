package com.mytech.articleservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> getAllArticles(){
        log.info("Getting a list with all articles!");
        return new ArrayList<>(repository.findAll());
    }

    public Article createArticle(  @RequestBody CreateArticleRequest createArticleRequest){
        log.info("Save a article!");

        Article article = new Article();
        article.setArticleId(createArticleRequest.articleId());
        article.setUserId(createArticleRequest.userId());
        article.setArticleTitle(createArticleRequest.articleTitle());
        article.setArticleContext(createArticleRequest.articleContext());
        article.setCreationDate(createArticleRequest.creationDate());

        //Article savedArticle = repository.save(article);
        return repository.save(article);
    }

}
