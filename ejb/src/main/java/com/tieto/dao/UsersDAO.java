package com.tieto.dao;

import com.tieto.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UsersDAO {

    @PersistenceContext(unitName = "javaEETutorial")
    private EntityManager entityManager;

    public User save(final User user) {
        if (this.entityManager.contains(user)) {
            return this.entityManager.merge(user);
        } else {
            this.entityManager.persist(user);
        }
        this.entityManager.flush();
        return user;
    }

    public void delete(final User user) {

        this.entityManager.remove(user);
    }

    public User getById(final Long id) {
        return this.entityManager.find(User.class, id);
    }

    public User getUserByCredentials(final String username, final String password) {

        final TypedQuery<User> query = this.entityManager.createQuery(
                "SELECT u from User u where u.username =:username and u.password=:password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    public Long getUsersCount(final String username, final String password) {

        final TypedQuery<Long> query = this.entityManager.createQuery(
                "SELECT count (u) from User u where u.username =:username and u.password=:password", Long.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    public List<User> isUsernameAlreadyInDatabase(final String username) {

        final TypedQuery<User> query =
                this.entityManager.createQuery("SELECT u from User u where u.username =:username", User.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

}
