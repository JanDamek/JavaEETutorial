package com.tieto.dao;

import com.tieto.entity.Author;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateless
public class AuthorDAO extends MainDAO<Author, Long> {

    @PostConstruct
    private void init() {
        super.setPersistedClass(Author.class);
    }

}
