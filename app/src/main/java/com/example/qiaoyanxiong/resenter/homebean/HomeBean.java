package com.example.qiaoyanxiong.resenter.homebean;

import java.io.Serializable;
import java.util.List;

public class HomeBean {

    private InfoBean info;
    private String mas;
    private String ret;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public String getMas() {
        return mas;
    }

    public void setMas(String mas) {
        this.mas = mas;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public static class InfoBean {


        private String fen;
        private List<UTypeBean> u_type;

        public String getFen() {
            return fen;
        }

        public void setFen(String fen) {
            this.fen = fen;
        }

        public List<UTypeBean> getU_type() {
            return u_type;
        }

        public void setU_type(List<UTypeBean> u_type) {
            this.u_type = u_type;
        }


    }
}
