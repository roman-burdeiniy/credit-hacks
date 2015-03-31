package com.credithacks.vo;

import javax.persistence.*;

/**
 * Created by roman_b on 3/26/2015.
 */
@Entity
@Table(name = "user_roles", schema = "", catalog = "credit_provider_db")
@IdClass(UserRolesVOPK.class)
public class UserRolesVO {
    private String rolename;
    private long username;
    private UsersVO usersByUserId;
    private RolesVO rolesByRolename;

    @Id
    @Column(name = "rolename")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Id
    @Column(name = "username")
    public long getUsername() {
        return username;
    }

    public void setUsername(long userId) {
        this.username = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesVO that = (UserRolesVO) o;

        if (username != that.username) return false;
        if (rolename != null ? !rolename.equals(that.rolename) : that.rolename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolename != null ? rolename.hashCode() : 0;
        result = 31 * result + (int) (username ^ (username >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "id", nullable = false)
    public UsersVO getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersVO usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "rolename", referencedColumnName = "rolename", nullable = false)
    public RolesVO getRolesByRolename() {
        return rolesByRolename;
    }

    public void setRolesByRolename(RolesVO rolesByRolename) {
        this.rolesByRolename = rolesByRolename;
    }
}
