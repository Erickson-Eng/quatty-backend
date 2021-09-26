package com.example.quattybackend.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "address")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Address implements Serializable {
    private static final long serialVersionUID = -542782125570411552L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String street;
    private String complement;
    @Column(nullable = false, length = 9)
    private String cep;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = {CascadeType.ALL})
    private City city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}