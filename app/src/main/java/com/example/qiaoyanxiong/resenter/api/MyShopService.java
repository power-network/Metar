package com.example.qiaoyanxiong.resenter.api;

import com.example.qiaoyanxiong.resenter.homebean.HomeBean;
import com.example.qiaoyanxiong.resenter.shop.bean.BookDataBean;
import com.example.qiaoyanxiong.resenter.shop.bean.KeChengDataBean;
import com.example.qiaoyanxiong.resenter.shop.bean.KechengBean;

import java.net.URL;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MyShopService {

    public String url = "https://app.yiyanmeng.com/index.php/";

    @POST("kecheng/ke_index_list")
    Observable<KeChengDataBean> getShop();


    @GET("Shiti/ti_type_list")
    Call<ResponseBody> getHome();
    //    URL https://app.yiyanmeng.com/index.php/kecheng/ke_index_list
    //https://app.yiyanmeng.com/index.php/shop/get_shop_list?p=1
    public String shurl = "https://app.yiyanmeng.com/";

    @POST("index.php/kecheng/ke_index_list")
    @FormUrlEncoded
    Observable<KeChengDataBean> getShop(@Field("type") int type, @Field("p") int p);

    @POST("index.php/shop/get_shop_list")
    @FormUrlEncoded
    Observable<BookDataBean> getBook(@Field("p") int p);
}
