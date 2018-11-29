package org.hibernate.lazyload.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "post_comments")
public class PostComment implements Serializable {

    private Long id;
    private Post post;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    public Post getPost() {
        return post;
    }
}
