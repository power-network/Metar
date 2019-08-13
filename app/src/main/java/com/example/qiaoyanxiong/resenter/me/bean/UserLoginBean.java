package com.example.qiaoyanxiong.resenter.me.bean;

public class UserLoginBean {

    public String ret;
    public LoginResultInfo info;

    public class UserInfo
    {
        public String id;
        public String pass;
        public String u_name;
        public String u_pic;
        public String phnoe;
        public String sex;
        public String yu_bao_ming;
        public String xinxi;
    }
    public class TokenInfo
    {
        public String access_token;
        public String expires;
        public String refreshTokenExpires;
        public String refresh_token;
    }
    public class LoginResultInfo
    {
        public UserInfo user_info;
        public TokenInfo token;
    }
    public String mas;

}
