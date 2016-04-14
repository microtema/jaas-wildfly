package de.seven.fate.jaas.dao;

import de.seven.fate.jaas.model.User;

import javax.inject.Inject;

/**
 * Created by Mario on 13.04.2016.
 */
public class UserDAO extends AbstractEntityDAO<User, Long> {

    @Inject
    private RoleDAO roleDAO;

    @Override
    protected void saveImpl(User entity) {

        //entity.setRoles(roleDAO.attach(entity.getRoles()));
        entity.setRoles(null);

        super.saveImpl(entity);
    }

    @Override
    protected User mergeImpl(User entity) {

        entity.setRoles(roleDAO.attach(entity.getRoles()));

        return super.mergeImpl(entity);
    }
}
