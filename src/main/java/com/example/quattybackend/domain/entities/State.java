package com.example.quattybackend.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "state")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class State implements Serializable {
    private static final long serialVersionUID = -2781809049122439075L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stateName;
    private String uf;
    @OneToMany(mappedBy = "state")
    @ToString.Exclude
    private List<City> cities = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        State state = (State) o;
        return Objects.equals(id, state.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}