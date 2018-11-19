package com.example.alitamoor.retrofitsample.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddUserPojo {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("displayname")
    @Expose
    private String displayname;
    @SerializedName("password")
    @Expose
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
