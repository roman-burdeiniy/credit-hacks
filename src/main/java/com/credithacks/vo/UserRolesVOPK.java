package com.credithacks.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by roman_b on 3/26/2015.
 */
public class UserRolesVOPK implements Serializable {
    private String rolename;
    private long username;

    @Column(name = "rolename")
    @Id
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Column(name = "username")
    @Id
    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesVOPK that = (UserRolesVOPK) o;

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
}
