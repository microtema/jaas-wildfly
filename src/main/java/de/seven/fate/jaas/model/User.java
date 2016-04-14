package de.seven.fate.jaas.model;

import com.sun.istack.NotNull;
import de.seven.fate.jaas.converter.PasswordConverter;
import de.seven.fate.jaas.dao.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Mario on 13.04.2016.
 */
@Table(name = "USERS", uniqueConstraints = {@UniqueConstraint(columnNames = "userName")})
@Entity
public class User extends BaseEntity<Long> {

    @NotNull
    private String userName;

    @NotNull
    @Convert(converter = PasswordConverter.class)
    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(roles, user.roles) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, roles);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userName", userName)
                .append("password", password)
                .toString();
    }
}
