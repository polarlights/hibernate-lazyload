package com.polarlights.jpa.lazyload.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "breeder")
public class Breeder implements Serializable {
  private Long id;
  private String name;

  private List<Bird> birds = new ArrayList<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  // bidirectional
  @OneToMany(mappedBy = "breeder")
  public List<Bird> getBirds() {
    return birds;
  }
}
