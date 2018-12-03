package org.hibernate.lazyload.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"postDetail", "postComments"})
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    private static final long serialVersionUID = 3812889283585210617L;
    private Long id;
    private String title;
    private String content;
    private PostDetail postDetail;
    private List<PostComment> postComments = new ArrayList<>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @OneToOne(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public PostDetail getPostDetail() {
        return postDetail;
    }

    public void addPostDetail(final PostDetail postDetail) {
        postDetail.setPost(this);
        setPostDetail(postDetail);
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<PostComment> getPostComments() {
        return postComments;
    }

    public void addPostComments(final PostComment postComment) {
        postComments.add(postComment);
        postComment.setPost(this);
    }
}
