package com.example.qiaoyanxiong.resenter;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.shop.bean.KeChengDataBean;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.qiaoyanxiong.resenter", appContext.getPackageName());
    }

    @Test
    public void getHttp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyShopService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<KeChengDataBean> shop = retrofit.create(MyShopService.class).getShop();
        shop.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<KeChengDataBean>() {
                    @Override
                    public void accept(KeChengDataBean keChengDataBean) throws Exception {
                        Log.e("lys", "accept: " + keChengDataBean.getInfo().getKecheng());
                    }
                });
    }
}
