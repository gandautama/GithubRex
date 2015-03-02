package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 02/03/15.
 */
public class Login {
    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    @SerializedName("http_code")
    int http_code;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @SerializedName("result")
    String result;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @SerializedName("data")
    public Data data;

    public class Data{
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public boolean isGeneratedUserName() {
            return generatedUserName;
        }

        public void setGeneratedUserName(boolean generatedUserName) {
            this.generatedUserName = generatedUserName;
        }


        public String getxBbSession() {
            return xBbSession;
        }

        public void setxBbSession(String xBbSession) {
            this.xBbSession = xBbSession;
        }

        public String getIsRole() {
            return isRole;
        }

        public void setIsRole(String isRole) {
            this.isRole = isRole;
        }

        public String getSignUpDate() {
            return signUpDate;
        }

        public void setSignUpDate(String signUpDate) {
            this.signUpDate = signUpDate;
        }

        @SerializedName("user")
        User user;

        @SerializedName("isRole")
        String isRole;

        @SerializedName ("signUpDate")
        String signUpDate;

        @SerializedName("generatedUserName")
        boolean generatedUserName;

        @SerializedName("X-BB-SESSION")
        String xBbSession;
    }

    public class User{

        public Role[] getRoles() {
            return roles;
        }

        public void setRoles(Role[] roles) {
            this.roles = roles;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @SerializedName("name")
        String name;
        @SerializedName("status")
        String status;
        @SerializedName("roles")
        Role[] roles;
    }

    public class Role{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @SerializedName("name")
        String name;





    }


}
