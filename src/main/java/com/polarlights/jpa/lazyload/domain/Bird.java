package com.polarlights.jpa.lazyload.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyGroup;

@Getter
@Setter
@ToString(of = {"id", "band"})
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "bird")
public class Bird implements Serializable {

    private Long id;
    private String band;
    private byte[] picture;
    private List<Award> awards = new ArrayList<>();
    private Specie specie;
    private Cage cage;
    private Breeder breeder;
    private List<Note> notes = new ArrayList<>();
    private Set<Treatment> treatments = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @LazyGroup("picture")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getPicture() {
        return picture;
    }

    // bidirectional
    @OneToMany(mappedBy = "bird")
    public List<Award> getAwards() {
        return awards;
    }

    // undirectional
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specie_id")
    public Specie getSpecie() {
        return specie;
    }

    // bidirectional
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cage_id")
    public Cage getCage() {
        return cage;
    }

    // bidirectional
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bird_id")
    public List<Note> getNotes() {
        return notes;
    }

    // bidirectional
    @ManyToMany
    @JoinTable(name = "bird_treatment", joinColumns = @JoinColumn(name = "bird_id"),
        inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    public Set<Treatment> getTreatments() {
        return treatments;
    }

    @ManyToOne
    @JoinColumn(name = "breeder_id")
    public Breeder getBreeder() {
        return breeder;
    }
}
