package com.example.commentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comments")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @PostMapping("comments")
    public Comment createComment(@RequestParam("articleId") int articleId, @RequestParam("userId") int userId, @RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.createComment(createCommentRequest, articleId, userId);
    }

    @RequestMapping("/commentbyaid")
    public List<Comment> getAllCommentsById(@RequestParam int articleId){ return commentService.getAllCommentsById(articleId);}

}
