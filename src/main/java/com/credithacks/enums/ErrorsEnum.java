package com.credithacks.enums;

/**
 * Created by roman_b on 3/19/2015.
 */
public enum ErrorsEnum {

    LOGIN_FAILED(100, "LOGIN_FAILED", "Login failed"),
    LOGOUT_FAILED(101, "LOGOUT_FAILED", "Logout failed");

    public int code;
    public String name;
    public String description;

    private ErrorsEnum(int code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }
}
