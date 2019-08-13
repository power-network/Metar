package com.example.qiaoyanxiong.resenter.course.presenter;

import com.example.qiaoyanxiong.resenter.course.bean.GongGaoBean;
import com.example.qiaoyanxiong.resenter.course.bean.KechengBean;
import com.example.qiaoyanxiong.resenter.course.bean.LunboBean;
import com.example.qiaoyanxiong.resenter.course.conter.CourseConter;
import com.example.qiaoyanxiong.resenter.course.modle.CourseModle;

import java.util.List;

public class CoursePresenter implements CourseConter.CoursePresenter, CourseConter.CourseModle.CallBack {
    private CourseConter.CourseModle modle;
    CourseConter.CourseView mview;

    public CoursePresenter(CourseConter.CourseView mview) {
        this.mview = mview;
        modle = new CourseModle();
    }

    @Override
    public void gethttp(int p) {
        if (mview != null) {
            modle.getData(this,p);
        }
    }

    @Override
    public void showArtSuccess(List<KechengBean> list) {
        mview.showArtSuccess(list);
    }

    @Override
    public void showBannSuccess(List<LunboBean> bannerData,List<GongGaoBean> gongGaoBeans) {
        mview.showBannSuccess(bannerData,gongGaoBeans);
    }

    @Override
    public void showError(String error) {
        mview.showError(error);
    }
}
