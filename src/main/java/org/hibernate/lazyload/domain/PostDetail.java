package org.hibernate.lazyload.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "post_details")
public class PostDetail implements Serializable {
   private Long id;

   @Id
   @GeneratedValue
    public Long getId() {
        return id;
    }
}
