package com.example.commentservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(){
        log.info("Getting a list with all articles!");
        return new ArrayList<>(commentRepository.findAll());
    }

    public List<Comment> getAllCommentsById(int articleId){
        log.info("Getting a list with all comments for article with ID: {}", articleId);
        return commentRepository.findByArticleId(articleId);
    }

    public Comment createComment(CreateCommentRequest createCommentRequest, int articleId, int userId){
        log.info("Save a article!");

        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setUserId(userId);
        comment.setComment(createCommentRequest.comment());
        comment.setCommentDate(createCommentRequest.commentDate());

        return commentRepository.save(comment);
    }
}
