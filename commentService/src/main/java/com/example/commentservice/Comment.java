package com.example.commentservice;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @SequenceGenerator(
            name = "comment_id_sequence",
            sequenceName = "comment_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_id_sequence"
    )
    @Column(name = "comment_id")
    int commentId;

    int articleId;
    int userId;
    String comment;
    Date commentDate;

    public Comment() {}

    public Comment(int commentId, int articleId, int userId, String comment, Date commentDate) {
        this.commentId = commentId;
        this.articleId = articleId;
        this.userId = userId;
        this.comment = comment;
        this.commentDate = commentDate;
    }
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
