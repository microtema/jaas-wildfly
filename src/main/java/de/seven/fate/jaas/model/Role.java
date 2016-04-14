package de.seven.fate.jaas.model;

import com.sun.istack.NotNull;
import de.seven.fate.jaas.dao.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Mario on 13.04.2016.
 */
@NamedQueries({
        @NamedQuery(name = Role.FIND_BY_ROLE, query = "SELECT r FROM Role r WHERE r.roleName = :roleName")
})
@Table(name = "ROLEX", uniqueConstraints = {@UniqueConstraint(columnNames = "roleName")})
@Entity
public class Role extends BaseEntity<Long> {

    public static final String FIND_BY_ROLE = "Role.findByRole";

    @NotNull
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("roleName", roleName)
                .toString();
    }
}
