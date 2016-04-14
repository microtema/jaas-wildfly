package de.seven.fate.jaas.dao;

import de.seven.fate.jaas.model.Role;
import de.seven.fate.model.util.CollectionUtil;

import javax.persistence.Query;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Mario on 13.04.2016.
 */
public class RoleDAO extends AbstractEntityDAO<Role, Long> {

    @Override
    public Role get(Role entity) {
        notNull(entity);

        if (entity.getId() != null) {
            return super.get(entity.getId());
        }

        if (entity.getRoleName() != null) {
            return getByRoleName(entity.getRoleName());
        }

        return null;
    }

    public Role saveOrUpdate(Role entity) {
        notNull(entity);

        Role recent = get(entity);

        if (recent == null) {
            save(entity);

            return entity;
        }

        return saveOrUpdate(recent, entity);
    }

    public Role getByRoleName(String roleName) {
        Query query = createNamedQuery(Role.FIND_BY_ROLE, "roleName", roleName);

        List<Role> resultList = query.getResultList();

        return CollectionUtil.first(resultList);
    }
}
