package com.tieto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("book")
@Data
public class Book extends Item {

    private static final long serialVersionUID = -2909642179108066361L;

    private String isbn;

}
