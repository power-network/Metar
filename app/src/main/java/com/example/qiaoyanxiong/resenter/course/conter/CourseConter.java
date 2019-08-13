package com.example.qiaoyanxiong.resenter.course.conter;

import com.example.qiaoyanxiong.resenter.course.bean.GongGaoBean;
import com.example.qiaoyanxiong.resenter.course.bean.KechengBean;
import com.example.qiaoyanxiong.resenter.course.bean.LunboBean;

import java.util.List;

public interface CourseConter {
    interface CourseView{
        void showArtSuccess(List<KechengBean> list);
        void showBannSuccess(List<LunboBean> bannerData,List<GongGaoBean> gongGaoBeans);

        void showError(String error);
    }

    interface CoursePresenter{
        void gethttp(int p);
    }

    interface CourseModle{
        interface CallBack{
            void showArtSuccess(List<KechengBean> list);
            void showBannSuccess(List<LunboBean> bannerData,List<GongGaoBean> gongGaoBeans);

            void showError(String error);
        }

        void getData(CallBack callBack,int p);
    }
}
