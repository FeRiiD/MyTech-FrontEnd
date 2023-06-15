package com.example.commentservice;

import java.util.Date;

public record CreateCommentRequest (int commentId,int articleId, int userId, String comment, Date commentDate){
}
