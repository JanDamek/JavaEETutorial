package com.tieto.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Entity
@Data
public class Author implements EntityWithId {

    private static final long serialVersionUID = 3762098544369382345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Item> books;
}
