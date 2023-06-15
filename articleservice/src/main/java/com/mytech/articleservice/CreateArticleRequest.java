package com.mytech.articleservice;

import java.util.Date;

public record CreateArticleRequest (int articleId, int userId, String articleTitle, String articleContext, Date creationDate ) {
}