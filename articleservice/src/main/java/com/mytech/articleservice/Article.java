package com.mytech.articleservice;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @SequenceGenerator(
            name = "article_id_sequence",
            sequenceName = "article_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_id_sequence"
    )
    @Column(name = "article_id")
    private Integer articleId;

    private Integer userId;
    private String articleTitle;
    private String articleContext;
    private Date creationDate;

    public Article() {}

    public Article(Integer userId, String articleTitle, String articleContext, Date creationDate) {
        this.userId = userId;
        this.articleTitle = articleTitle;
        this.articleContext = articleContext;
        this.creationDate = creationDate;
    }

    public Article(Integer articleId, Integer userId, String articleTitle, String articleContext, Date creationDate) {
        this.articleId = articleId;
        this.userId = userId;
        this.articleTitle = articleTitle;
        this.articleContext = articleContext;
        this.creationDate = creationDate;
    }


    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleContext(String articleContext) {
        this.articleContext = articleContext;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", userId=" + userId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContext='" + articleContext + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}