package com.example.qiaoyanxiong.resenter.course.bean;

import java.util.List;

public class CourseBean {

    /**
     * ret : 200
     * info : {"kecheng":[{"id":"30","name":"高能直播课-西综直播课","class_hour":"64","type":"0","pic":"https://app.yiyanmeng.com:443/Public/user/2019-04-26/5cc2ab2961a17.png","jia_ge":"11990.00","yuan_jia_ge":"11990.00","price_status":"0","type_str":[]},{"id":"32","name":"无忧视频课-西综全程","class_hour":"28","type":"0","pic":"https://app.yiyanmeng.com:443/Public/user/2019-04-26/5cc2abdfe157b.png","jia_ge":"1380.00","yuan_jia_ge":"1380.00","price_status":"0","type_str":["最新"]}],"lunbo":[{"id":"1","pic":"https://app.yiyanmeng.com:443/Public/lunbo/15621494432758.jpg","url":"https://app.yiyanmeng.com:443/"}],"gong_gao":[{"id":"5","name":"冲刺押题集训","url":"https://app.yiyanmeng.com:443/index.php/index/gong_gao/id/5.html"},{"id":"4","name":"20医考高端直播课程","url":"https://app.yiyanmeng.com:443/index.php/index/gong_gao/id/4.html"},{"id":"3","name":"20医考全年集训","url":"https://app.yiyanmeng.com:443/index.php/index/gong_gao/id/3.html"},{"id":"2","name":"2020医考寒假超越计划","url":"https://app.yiyanmeng.com:443/index.php/index/gong_gao/id/2.html"},{"id":"1","name":"2019课程设置","url":"https://app.yiyanmeng.com:443/index.php/index/gong_gao/id/1.html"}]}
     * mas : 成功
     */

    private String ret;
    private InfoBean info;
    private String mas;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

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

    public static class InfoBean {
        private List<KechengBean> kecheng;
        private List<LunboBean> lunbo;
        private List<GongGaoBean> gong_gao;

        public List<KechengBean> getKecheng() {
            return kecheng;
        }

        public void setKecheng(List<KechengBean> kecheng) {
            this.kecheng = kecheng;
        }

        public List<LunboBean> getLunbo() {
            return lunbo;
        }

        public void setLunbo(List<LunboBean> lunbo) {
            this.lunbo = lunbo;
        }

        public List<GongGaoBean> getGong_gao() {
            return gong_gao;
        }

        public void setGong_gao(List<GongGaoBean> gong_gao) {
            this.gong_gao = gong_gao;
        }

    }
}
