package org.hibernate.lazyload.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable {
    private Long id;
    private PostDetail postDetail;
    private List<PostComment> postComments = new ArrayList<>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @OneToOne
    public PostDetail getPostDetail() {
        return postDetail;
    }

    @OneToMany
    public List<PostComment> getPostComments() {
        return postComments;
    }
}
