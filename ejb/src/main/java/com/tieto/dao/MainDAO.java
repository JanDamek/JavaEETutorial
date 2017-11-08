package com.tieto.dao;

import com.tieto.entity.EntityWithId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
public class MainDAO<T extends EntityWithId> implements Serializable {

    @PersistenceContext(unitName = "javaEETutorial")
    transient EntityManager em;
    private Class<? extends T> persistedClass;

    public void setPersistedClass(final Class<? extends T> persistedClass) {
        this.persistedClass = persistedClass;
    }

    public void save(final T user) {
        if (this.em.contains(user)) {
            this.em.merge(user);
        } else {
            this.em.persist(user);
        }
    }

    public void delete(final T user) {
        if (this.em.contains(user)) {
            this.em.remove(user);
        } else {
            final Query query = this.em.createQuery(String.format("DELETE FROM %s t WHERE t.id = :id",
                    this.persistedClass.getSimpleName()));
            query.setParameter("id", user.getId());
            query.executeUpdate();
        }
    }

    public T getById(final Long id) {
        return this.em.find(this.persistedClass, id);
    }

    public List<T> getAll() {
        final TypedQuery<? extends T> query =
                this.em.createQuery(
                        String.format("SELECT t FROM %s t", this.persistedClass.getSimpleName()),
                        this.persistedClass);
        return new ArrayList<T>(query.getResultList());
    }
}
