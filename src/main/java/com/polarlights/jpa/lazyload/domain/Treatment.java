package com.polarlights.jpa.lazyload.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "treatment")
public class Treatment implements Serializable  {
  private Long id;
  private String name;
  private Set<Bird> birds = new HashSet<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  // bidirectional
  @ManyToMany(mappedBy = "treatments", cascade = CascadeType.ALL)
  public Set<Bird> getBirds() {
    return birds;
  }
}
