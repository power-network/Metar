package com.example.qiaoyanxiong.resenter.me.bean;

import java.util.List;

public class NoticeBean {
    public String ret;
    public String mas;
    public List<NewsInfo> info;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMas() {
        return mas;
    }

    public void setMas(String mas) {
        this.mas = mas;
    }

    public List<NewsInfo> getInfo() {
        return info;
    }

    public void setInfo(List<NewsInfo> info) {
        this.info = info;
    }

    public class NewsInfo
    {
        public String id;
        public String title;
        public String addtime;
        public String authName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getAuthName() {
            return authName;
        }

        public void setAuthName(String authName) {
            this.authName = authName;
        }
    }
}
