package com.zychen.xml;

/**
 * @author 章源辰
 * @time: 2017/9/28 23:09
 * @describion:
 */
public class User {

    @Mapper("user_name")
    private String userName;
    @Mapper("password")
    private String password;
    @Mapper("bbb")
    private String aaa;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", aaa='" + aaa + '\'' +
                '}';
    }

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

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }
}
