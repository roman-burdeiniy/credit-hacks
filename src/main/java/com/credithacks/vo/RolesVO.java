package com.credithacks.vo;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by roman_b on 3/26/2015.
 */
@Entity
@Table(name = "roles", schema = "", catalog = "credit_provider_db")
public class RolesVO {
    private String rolename;
    private Collection<UserRolesVO> userRolesesByRolename;

    @Id
    @Column(name = "rolename")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesVO that = (RolesVO) o;

        if (rolename != null ? !rolename.equals(that.rolename) : that.rolename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return rolename != null ? rolename.hashCode() : 0;
    }

    @OneToMany(mappedBy = "rolesByRolename")
    public Collection<UserRolesVO> getUserRolesesByRolename() {
        return userRolesesByRolename;
    }

    public void setUserRolesesByRolename(Collection<UserRolesVO> userRolesesByRolename) {
        this.userRolesesByRolename = userRolesesByRolename;
    }
}
