package com.credithacks.vo;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by roman_b on 3/26/2015.
 */
@Entity
@Table(name = "users", schema = "", catalog = "credit_provider_db")
@NamedQueries({
        @NamedQuery(name="UsersVO.getAll", query="SELECT u FROM UsersVO u"),
        @NamedQuery(name="UsersVO.geUserByName", query="SELECT u FROM UsersVO u WHERE u.username = :username")
})
public class UsersVO {
    private long id;
    private String username;
    private byte[] password;
    private String email;
    private String phone;
    private byte[] salt;
    private Collection<UserRolesVO> userRolesesById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "salt")
    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersVO that = (UsersVO) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (!Arrays.equals(password, that.password)) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (!Arrays.equals(salt, that.salt)) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? Arrays.hashCode(password) : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (salt != null ? Arrays.hashCode(salt) : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId", cascade = CascadeType.ALL)
    public Collection<UserRolesVO> getUserRolesesById() {
        return userRolesesById;
    }

    public void setUserRolesesById(Collection<UserRolesVO> userRolesesById) {
        this.userRolesesById = userRolesesById;
    }
}
