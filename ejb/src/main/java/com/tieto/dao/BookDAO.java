package com.tieto.dao;

import com.tieto.entity.Book;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Stateless
public class BookDAO extends MainDAO<Book> {

    @PostConstruct
    private void init() {
        super.setPersistedClass(Book.class);
    }

}
