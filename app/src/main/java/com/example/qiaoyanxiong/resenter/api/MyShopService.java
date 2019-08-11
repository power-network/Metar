package com.example.qiaoyanxiong.resenter.api;

import com.example.qiaoyanxiong.resenter.homebean.HomeBean;
import com.example.qiaoyanxiong.resenter.shop.bean.KeChengDataBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MyShopService {

    public String url = "https://app.yiyanmeng.com/index.php/";

    @POST("kecheng/ke_index_list")
    Observable<KeChengDataBean> getShop();


    @GET("Shiti/ti_type_list")
    Call<ResponseBody> getHome();
}
