package com.tieto.dao;

import com.tieto.entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UsersDAO extends MainDAO<User> {

    @PostConstruct
    private void init() {
        super.setPersistedClass(User.class);
    }

    public User getUserByCredentials(final String username, final String password) {

        final TypedQuery<User> query = this.em.createQuery(
                "SELECT u from User u where u.username =:username and u.password=:password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    public Long getUsersCount(final String username, final String password) {

        final TypedQuery<Long> query = this.em.createQuery(
                "SELECT count (u) from User u where u.username =:username and u.password=:password", Long.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    public List<User> isUsernameAlreadyInDatabase(final String username) {

        final TypedQuery<User> query =
                this.em.createQuery("SELECT u from User u where u.username =:username", User.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

}
