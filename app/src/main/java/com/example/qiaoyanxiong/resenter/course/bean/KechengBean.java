package com.example.qiaoyanxiong.resenter.course.bean;

import java.util.List;

public class KechengBean {
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
    private List<String> type_str;

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

    public List<String> getType_str() {
        return type_str;
    }

    public void setType_str(List<String> type_str) {
        this.type_str = type_str;
    }
}
