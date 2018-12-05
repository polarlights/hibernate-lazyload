package com.polarlights.jpa.lazyload.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"id", "title"})
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "award")
public class Award implements Serializable {
  private Long id;
  private String titile;

  private Bird bird;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  // bidirectional
  @ManyToOne
  @JoinColumn(name = "bird_id")
  public Bird getBird() {
    return bird;
  }
}
