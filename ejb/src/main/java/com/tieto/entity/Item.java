package com.tieto.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "utype", discriminatorType = DiscriminatorType.STRING)
public class Item implements EntityWithId {

    private static final long serialVersionUID = -4530425363130378467L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "placeFor")
    private Set<Place> places;
}
