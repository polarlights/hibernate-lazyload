package org.hibernate.lazyload.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Data
@ToString(exclude = "post")
@Entity
@Table(name = "post_comments")
public class PostComment implements Serializable {

    private static final long serialVersionUID = -5058185386831525278L;
    private Long id;
    private String email;
    private String content;
    private Post post;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    public Post getPost() {
        return post;
    }
}
