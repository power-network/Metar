package com.example.qiaoyanxiong.resenter.course.modle;

import android.util.Log;

import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.course.bean.CourseBean;
import com.example.qiaoyanxiong.resenter.course.conter.CourseConter;
import com.example.qiaoyanxiong.resenter.utils.BaseObsever;
import com.example.qiaoyanxiong.resenter.utils.HttpManager;
import com.example.qiaoyanxiong.resenter.utils.RxUtils;

public class CourseModle implements CourseConter.CourseModle {
    @Override
    public void getData(final CallBack callBack,int p) {
        HttpManager.getHttpManager().getApiService(MyShopService.courUrl,MyShopService.class)
                .getCour(p)
                .compose(RxUtils.<CourseBean>rxScheduleThread())
                .subscribe(new BaseObsever<CourseBean>() {
                    @Override
                    public void onNext(CourseBean courseBean) {
                        callBack.showArtSuccess(courseBean.getInfo().getKecheng());
                        callBack.showBannSuccess(courseBean.getInfo().getLunbo(),courseBean.getInfo().getGong_gao());
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.showError(e.getMessage());
                        Log.e("qiao", "onError: " + e.getMessage());
                    }
                });
    }
}
