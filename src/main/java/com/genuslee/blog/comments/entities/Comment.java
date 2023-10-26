package com.genuslee.blog.comments.entities;


import com.genuslee.blog.category.entities.Category;
import com.genuslee.blog.post.entities.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_comment")
public class Comment {

    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "comment_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long commentId;
    private String title;
    private String content;
    private String username;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "postId"
    )
    private Post post;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
