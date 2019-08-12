package com.example.qiaoyanxiong.resenter.shop.bean;

import java.util.List;

public class BookDataBean {


    /**
     * ret : 200
     * info : [{"id":"51","name":"十天玩转内科（用导图扩展思维）","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/9ee3ce397e80bf2912772b4b6d55e7aa.jpg","hao_ping":"5","xian_price":"79.00","re_mai":"1"},{"id":"42","name":"2020马上爱内科--覆盖99分内科全部大纲考点","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/440bf4d06388b777c127257716783ad5.jpg","hao_ping":"5","xian_price":"109.00","re_mai":"1"},{"id":"35","name":"外科强化满分秘籍","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/309fcde7a5650b175dd3f7fe827f274e.jpg","hao_ping":"5","xian_price":"109.00","re_mai":"1"},{"id":"49","name":"2020内科题库（赠10年内外科真题视频详解）","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/0e8ded47faf07df91cc2dbc9582e8b28.jpg","hao_ping":"5","xian_price":"119.00","re_mai":"1"},{"id":"48","name":"2020外科题库（赠10年内外科真题视频详解）","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/606a05b8a439325c0ff68e13b7c484e4.jpg","hao_ping":"5","xian_price":"119.00","re_mai":"1"},{"id":"44","name":"生化学零笔记","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/23e5d7dd89bc4e41f76086bc86595aa2.jpg","hao_ping":"5","xian_price":"99.00","re_mai":"1"},{"id":"43","name":"生理学零笔记","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/a03766cf2d7f0a3a9c9ddb3160e87927.jpg","hao_ping":"5","xian_price":"99.00","re_mai":"1"},{"id":"11","name":"2020年西综（上下册）","pic":"https://app.yiyanmeng.com:443/Public/shop_xiang_qing/1ac0cb20e2bd4e2c96eb2b7a03c517d8.jpg","hao_ping":"5","xian_price":"179.00","re_mai":"1"}]
     * mas : 成功
     */

    private String ret;
    private String mas;
    private List<InfoBean> info;

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

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * id : 51
         * name : 十天玩转内科（用导图扩展思维）
         * pic : https://app.yiyanmeng.com:443/Public/shop_xiang_qing/9ee3ce397e80bf2912772b4b6d55e7aa.jpg
         * hao_ping : 5
         * xian_price : 79.00
         * re_mai : 1
         */

        private String id;
        private String name;
        private String pic;
        private String hao_ping;
        private String xian_price;
        private String re_mai;

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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getHao_ping() {
            return hao_ping;
        }

        public void setHao_ping(String hao_ping) {
            this.hao_ping = hao_ping;
        }

        public String getXian_price() {
            return xian_price;
        }

        public void setXian_price(String xian_price) {
            this.xian_price = xian_price;
        }

        public String getRe_mai() {
            return re_mai;
        }

        public void setRe_mai(String re_mai) {
            this.re_mai = re_mai;
        }
    }
}
