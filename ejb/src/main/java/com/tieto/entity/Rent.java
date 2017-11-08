package com.tieto.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Entity
@Data
public class Rent implements EntityWithId {

    private static final long serialVersionUID = 8916520718309835790L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Item item;

    private Date rentDate;

    private Integer rentFor;
}
