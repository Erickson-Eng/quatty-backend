package com.example.quattybackend.domain.entities;

import com.example.quattybackend.domain.entities.enums.BasketballPosition;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "athlete")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Athlete implements Serializable {
    private static final long serialVersionUID = 849589476800986227L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, length = 14)
    private String cpf;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Address address;

    private Double weight;
    private Double height;

    @Enumerated(EnumType.STRING)
    private BasketballPosition position;

    @OneToOne
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Athlete athlete = (Athlete) o;
        return Objects.equals(id, athlete.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}