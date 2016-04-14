package de.seven.fate.jaas.builder;

import de.seven.fate.jaas.model.User;
import de.seven.fate.model.builder.AbstractModelBuilder;

import javax.inject.Inject;

/**
 * Created by Mario on 13.04.2016.
 */
public class UserBuilder extends AbstractModelBuilder<User> {

    private final RoleBuilder roleBuilder;

    @Inject
    public UserBuilder(RoleBuilder roleBuilder) {
        this.roleBuilder = roleBuilder;
    }

    @Override
    public User min() {
        User min = super.min();

        min.setId(null);
        min.setCreatedDate(null);
        min.setVersion(null);
        min.setUpdateDate(null);

        min.setRoles(roleBuilder.set());

        return min;
    }
}
