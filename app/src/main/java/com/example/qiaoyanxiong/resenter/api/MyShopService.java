package com.example.qiaoyanxiong.resenter.api;

import com.example.qiaoyanxiong.resenter.course.bean.CourseBean;
import com.example.qiaoyanxiong.resenter.me.bean.InfoBean;
import com.example.qiaoyanxiong.resenter.me.bean.NoticeBean;
import com.example.qiaoyanxiong.resenter.me.bean.UserLoginBean;
import com.example.qiaoyanxiong.resenter.shop.bean.BookDataBean;
import com.example.qiaoyanxiong.resenter.shop.bean.KeChengDataBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyShopService {
    //    URL https://app.yiyanmeng.com/index.php/kecheng/ke_index_list
    //https://app.yiyanmeng.com/index.php/shop/get_shop_list?p=1
    public String url = "https://app.yiyanmeng.com/";
    public String courUrl = "https://app.yiyanmeng.com";

    @POST("index.php/kecheng/ke_index_list")
    @FormUrlEncoded
    Observable<KeChengDataBean> getShop(@Field("type") int type, @Field("p") int p);

    @POST("index.php/shop/get_shop_list")
    @FormUrlEncoded
    Observable<BookDataBean> getBook(@Field("p") int p);

    @GET("kecheng/ke_index_list")
    Observable<CourseBean> getCour(@Query("p") int p);

    @POST("index.php/login/login")
    @FormUrlEncoded
    Observable<UserLoginBean> testLogin(@Field("name") String name, @Field("pass") String pass);

    @POST("index.php/login/login")
    @FormUrlEncoded
    Observable<UserLoginBean> testPhones(@Field("type") String type,@Field("name") String name, @Field("pass") String pass);


    @POST("index.php/paywx/massage")
    @FormUrlEncoded
    Observable<ResponseBody> testPhone(@Field("type") String type, @Field("phone") String phone);

    @POST("index.php/paywx/massage")
    @FormUrlEncoded
    Observable<UserLoginBean> testRegis(@Field("phone") String phone, @Field("type") String type);

    @POST("index.php/login/login_zhuce")
    @FormUrlEncoded
    Observable<UserLoginBean> testResaig(@Field("type") String type,@Field("phone") String phone,@Field("code") String code,@Field("pass") String pass);

    @GET("index.php/forum/notice_list")
    Observable<NoticeBean> testNotice(@Query("p") String p, @Header("A-uthorization") String header);

    @GET("index.php/forum/notice_list")
    Observable<InfoBean> testmepre(@Header("A-uthorization") String header);

}
