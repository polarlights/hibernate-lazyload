package org.hibernate.lazyload.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "post")
@Entity
@Table(name = "post_details")
public class PostDetail implements Serializable {

    private static final long serialVersionUID = 1909875331452713977L;
    private Long id;
    private String description;

    private Post post;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "post_id")
    public Post getPost() {
        return post;
    }
}
