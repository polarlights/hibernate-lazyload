package com.polarlights.jpa.lazyload.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"id", "content"})
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "note")
public class Note implements Serializable {
   private Long id;
   private String content;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long getId() {
      return id;
   }
}
