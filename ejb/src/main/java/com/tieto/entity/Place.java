package com.tieto.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Entity
@Data
public class Place implements EntityWithId {

    private static final long serialVersionUID = 9066270585499061703L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "positionWhereAre")
    private String where;

    private boolean free;

    @ManyToOne
    private Item placeFor;
}
