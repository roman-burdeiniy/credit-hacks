package com.credithacks;

import javax.ejb.Stateful;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/8/13
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateful
public class EntityManagerProvider implements Serializable {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }

}
