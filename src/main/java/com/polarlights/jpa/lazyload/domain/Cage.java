package com.polarlights.jpa.lazyload.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Getter
@Setter
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "cage")
public class Cage implements Serializable {
   private Long id;
   private String name;

   private Bird bird;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long getId() {
      return id;
   }

   // bidirectional
   @OneToOne(fetch = FetchType.LAZY, optional = true)
   @LazyToOne(LazyToOneOption.NO_PROXY)
   public Bird getBird() {
      return bird;
   }
}
