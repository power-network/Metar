package com.example.qiaoyanxiong.resenter.api;

import com.example.qiaoyanxiong.resenter.shop.bean.KeChengDataBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface MyShopService {

    public String url = "https://app.yiyanmeng.com/";

    @POST("index.php/kecheng/ke_index_list")
    Observable<KeChengDataBean> getShop();
}
