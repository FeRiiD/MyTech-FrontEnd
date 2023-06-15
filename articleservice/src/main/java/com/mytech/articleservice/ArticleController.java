package com.mytech.articleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody CreateArticleRequest request) {
        Article createdArticle = articleService.createArticle(request);
        return ResponseEntity.ok(createdArticle);
    }


}
