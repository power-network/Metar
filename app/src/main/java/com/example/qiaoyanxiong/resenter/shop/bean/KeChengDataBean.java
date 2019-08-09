package com.example.qiaoyanxiong.resenter.shop.bean;

import java.util.List;

public class KeChengDataBean {

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


        public static class KechengBean {
            @Override
            public String toString() {
                return "KechengBean{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", class_hour='" + class_hour + '\'' +
                        ", type='" + type + '\'' +
                        ", pic='" + pic + '\'' +
                        ", jia_ge='" + jia_ge + '\'' +
                        ", yuan_jia_ge='" + yuan_jia_ge + '\'' +
                        ", price_status='" + price_status + '\'' +
                        ", type_str=" + type_str +
                        '}';
            }

            /**
             * id : 30
             * name : 高能直播课-西综直播课
             * class_hour : 64
             * type : 0
             * pic : https://app.yiyanmeng.com:443/Public/user/2019-04-26/5cc2ab2961a17.png
             * jia_ge : 11990.00
             * yuan_jia_ge : 11990.00
             * price_status : 0
             * type_str : []
             */

            private String id;
            private String name;
            private String class_hour;
            private String type;
            private String pic;
            private String jia_ge;
            private String yuan_jia_ge;
            private String price_status;
            private List<?> type_str;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getClass_hour() {
                return class_hour;
            }

            public void setClass_hour(String class_hour) {
                this.class_hour = class_hour;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getJia_ge() {
                return jia_ge;
            }

            public void setJia_ge(String jia_ge) {
                this.jia_ge = jia_ge;
            }

            public String getYuan_jia_ge() {
                return yuan_jia_ge;
            }

            public void setYuan_jia_ge(String yuan_jia_ge) {
                this.yuan_jia_ge = yuan_jia_ge;
            }

            public String getPrice_status() {
                return price_status;
            }

            public void setPrice_status(String price_status) {
                this.price_status = price_status;
            }

            public List<?> getType_str() {
                return type_str;
            }

            public void setType_str(List<?> type_str) {
                this.type_str = type_str;
            }
        }

        public static class LunboBean {
            /**
             * id : 1
             * pic : https://app.yiyanmeng.com:443/Public/lunbo/15621494432758.jpg
             * url : https://app.yiyanmeng.com:443/
             */

            private String id;
            private String pic;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class GongGaoBean {
            /**
             * id : 5
             * name : 冲刺押题集训
             * url : https://app.yiyanmeng.com:443/index.php/index/gong_gao/id/5.html
             */

            private String id;
            private String name;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
