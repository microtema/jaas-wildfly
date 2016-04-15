package de.seven.fate.jaas.builder;

import de.seven.fate.jaas.model.Role;
import de.seven.fate.model.builder.AbstractModelBuilder;
import de.seven.fate.model.util.CollectionUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Mario on 13.04.2016.
 */
public class RoleBuilder extends AbstractModelBuilder<Role> {

    private static final List<String> ROLES = Arrays.asList("ADMIN", "USER", "GUEST", "SUPER");

    @Override
    public Role min() {
        Role min = super.min();

        min.setId(null);
        min.setCreatedDate(null);
        min.setVersion(null);
        min.setUpdateDate(null);

        min.setRoleName(CollectionUtil.random(ROLES));

        return min;
    }

    @Override
    public List<Role> list() {
        return super.list(ROLES.size() - 1);
    }

    @Override
    public Set<Role> set() {
        return super.set(ROLES.size() - 1);
    }
}
