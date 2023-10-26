package com.genuslee.blog.post.entities;


import com.genuslee.blog.category.entities.Category;
import com.genuslee.blog.user.entities.User;
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
@Table(name = "tbl_post")
public class Post {

    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "post_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long postId;
    private String title;
    private String description;
    private String photo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "userId"
    )
    private User postOwner;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
