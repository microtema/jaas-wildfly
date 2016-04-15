package it.de.seven.fate.jaas.dao;

import de.seven.fate.jaas.builder.RoleBuilder;
import de.seven.fate.jaas.builder.UserBuilder;
import de.seven.fate.jaas.dao.RoleDAO;
import de.seven.fate.jaas.dao.UserDAO;
import de.seven.fate.jaas.model.Role;
import de.seven.fate.jaas.model.User;
import de.seven.fate.model.util.CollectionUtil;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.Set;

/**
 * Created by Mario on 13.04.2016.
 */
@RunWith(Arquillian.class)
public class UserDAOIT {

    @Inject
    UserDAO sut;

    @Inject
    RoleDAO roleDAO;

    @Inject
    UserBuilder builder;

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction transaction;

    List<User> models;

    @Deployment
    public static WebArchive createDeployment() {
        return DeploymentUtil.createDeployment();
    }

    @Before
    public void setUp() throws Exception {

        models = builder.list();

        transactional(() -> {
            models.forEach((user) -> {
                user.getRoles().forEach(roleDAO::saveOrUpdate);
            });
        });

        transactional(() -> sut.save(models));
    }

    @After
    public void tearDown() throws Exception {

        transactional(sut::removeAll);
        transactional(roleDAO::removeAll);
    }

    @Test
    public void test() throws Exception {
        User model = CollectionUtil.random(models);
        model.setPassword("admin");

        transactional(() -> sut.saveOrUpdate(models));

        User entity = sut.get(model);
        Assert.assertEquals("jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=", entity.getPassword());
    }

    private void transactional(Runnable runnable) throws Exception {
        transaction.begin();
        em.joinTransaction();

        runnable.run();

        transaction.commit();
    }

}
