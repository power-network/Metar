package com.example.qiaoyanxiong.resenter.homebean;

import java.io.Serializable;
import java.util.List;

public class UTypeBean implements Serializable {

    private String ban_ben;
    private String id;
    private String jianjie;
    private String name;
    private String pai;
    private String pid;
    private String status;
    private String ti_ping_num;
    private String type_id;
    private String xishu;
    private String yizuo;
    private String zong;
    private String zuo;
    private List<ZTypeBean> z_type;

    public String getBan_ben() {
        return ban_ben;
    }

    public void setBan_ben(String ban_ben) {
        this.ban_ben = ban_ben;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTi_ping_num() {
        return ti_ping_num;
    }

    public void setTi_ping_num(String ti_ping_num) {
        this.ti_ping_num = ti_ping_num;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getXishu() {
        return xishu;
    }

    public void setXishu(String xishu) {
        this.xishu = xishu;
    }

    public String getYizuo() {
        return yizuo;
    }

    public void setYizuo(String yizuo) {
        this.yizuo = yizuo;
    }

    public String getZong() {
        return zong;
    }

    public void setZong(String zong) {
        this.zong = zong;
    }

    public String getZuo() {
        return zuo;
    }

    public void setZuo(String zuo) {
        this.zuo = zuo;
    }

    public List<ZTypeBean> getZ_type() {
        return z_type;
    }

    public void setZ_type(List<ZTypeBean> z_type) {
        this.z_type = z_type;
    }

    public static class ZTypeBean implements Serializable {
        /**
         * ban_ben : 11468
         * biao_name : T_K_BBC
         * id : 112
         * jianjie :
         * name : 诊断学
         * pai : 0
         * pid : 58
         * status : 0
         * ti_ping_num : 0
         * type_id : 112
         * xishu : 1.00
         * yizuo : 3033
         * zong : 60
         * zuo : 0
         */

        private String ban_ben;
        private String biao_name;
        private String id;
        private String jianjie;
        private String name;
        private String pai;
        private String pid;
        private String status;
        private String ti_ping_num;
        private String type_id;
        private String xishu;
        private String yizuo;
        private String zong;
        private String zuo;

        public String getBan_ben() {
            return ban_ben;
        }

        public void setBan_ben(String ban_ben) {
            this.ban_ben = ban_ben;
        }

        public String getBiao_name() {
            return biao_name;
        }

        public void setBiao_name(String biao_name) {
            this.biao_name = biao_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJianjie() {
            return jianjie;
        }

        public void setJianjie(String jianjie) {
            this.jianjie = jianjie;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPai() {
            return pai;
        }

        public void setPai(String pai) {
            this.pai = pai;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTi_ping_num() {
            return ti_ping_num;
        }

        public void setTi_ping_num(String ti_ping_num) {
            this.ti_ping_num = ti_ping_num;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getXishu() {
            return xishu;
        }

        public void setXishu(String xishu) {
            this.xishu = xishu;
        }

        public String getYizuo() {
            return yizuo;
        }

        public void setYizuo(String yizuo) {
            this.yizuo = yizuo;
        }

        public String getZong() {
            return zong;
        }

        public void setZong(String zong) {
            this.zong = zong;
        }

        public String getZuo() {
            return zuo;
        }

        public void setZuo(String zuo) {
            this.zuo = zuo;
        }
    }
}