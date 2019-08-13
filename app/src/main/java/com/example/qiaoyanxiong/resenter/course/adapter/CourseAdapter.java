package com.example.qiaoyanxiong.resenter.course.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.course.bean.GongGaoBean;
import com.example.qiaoyanxiong.resenter.course.bean.KechengBean;
import com.example.qiaoyanxiong.resenter.course.bean.LunboBean;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<KechengBean> artlist = new ArrayList<>();
    List<LunboBean> lunbolist = new ArrayList<>();
    List<GongGaoBean> gonglist = new ArrayList<>();
    List<String> itemlist = new ArrayList<>();
    String item = "精品课程";


    public CourseAdapter(Context context) {
        this.context = context;
    }

    public void initArt(List<KechengBean> artlist){
        if (this.artlist != null){
            this.artlist.addAll(artlist);
        }
        notifyDataSetChanged();
    }

    public void initBanner(List<LunboBean> lunbolist,List<GongGaoBean> gonglist){
        if (this.lunbolist != null){
            this.lunbolist.addAll(lunbolist);
        }
        if (this.gonglist != null){
            this.gonglist.addAll(gonglist);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int type = getItemViewType(i);
        if (type == 0){
            View view = View.inflate(context, R.layout.header_class_layout, null);
            return new LunViewHolder(view);
        }else if (type == 1){
            View view = View.inflate(context, R.layout.item_gongan_marview, null);
            return new GonViewHolder(view);
        }else if (type == 2){
            View view = View.inflate(context, R.layout.item_coures_layout, null);
            return new ItemViewHolder(view);
        }else {
            View view = View.inflate(context, R.layout.item_shop_kecheng, null);
            return new ArtViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);

        if (type == 0){
            LunViewHolder lunViewHolder = (LunViewHolder) viewHolder;
            lunViewHolder.lunbol.setImages(lunbolist).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    LunboBean banne = (LunboBean) path;
                    Glide.with(context).load(banne.getPic()).into(imageView);
                }
            }).start();

        }else if (type == 1){
            GonViewHolder gonViewHolder = (GonViewHolder) viewHolder;
            ArrayList list = new ArrayList<>();
            for (int j = 0; j < gonglist.size(); j++) {
                list.add(gonglist.get(j).getName());
            }
            gonViewHolder.marqueeView.startWithList(list);
        }else if (type == 2){
            ItemViewHolder item1 = (ItemViewHolder) viewHolder;
            itemlist.add(item);
            item1.item_str.setText(itemlist.get(i));
        }else {
            if (lunbolist.size()>0){
                i = i-1;
            }
            if (gonglist.size()>0){
                i = i - 1;
            }
            if (itemlist.size()>0){
                i = i - 1;
            }
            KechengBean kechengBean = artlist.get(i);
            ArtViewHolder artViewHolder = (ArtViewHolder) viewHolder;
            artViewHolder.arttitle.setText(kechengBean.getName());
            artViewHolder.artmoney.setText(kechengBean.getYuan_jia_ge());
            artViewHolder.artkeshi.setText(kechengBean.getClass_hour()+"课时");

            if (kechengBean.getType_str() != null && kechengBean.getType_str().size() > 0 && !TextUtils.isEmpty(kechengBean.getType_str().get(0))){
                artViewHolder.artnew.setText(kechengBean.getType_str().get(0));
            }
            if (kechengBean.getType_str() != null && kechengBean.getType_str().size() > 1 && !TextUtils.isEmpty(kechengBean.getType_str().get(1))){
                artViewHolder.artnew.setText(kechengBean.getType_str().get(1));
            }
            if (kechengBean.getType_str() != null && kechengBean.getType_str().size() > 2 && !TextUtils.isEmpty(kechengBean.getType_str().get(2))){
                artViewHolder.artnew.setText(kechengBean.getType_str().get(2));
            }

            Glide.with(context).load(kechengBean.getPic()).into(artViewHolder.artimg);
        }
    }

    @Override
    public int getItemCount() {
        if (lunbolist.size() > 0){
            return artlist.size()+1;
        }else if (gonglist.size() > 0){
            return artlist.size()+1;
        }else if (itemlist.size()>0){
            return artlist.size()+1;
        }else {
            return artlist.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (lunbolist.size() > 0 && position == 0){
            return 0;
        }else if (gonglist.size() > 0 && position == 1){
            return 1;
        }else if (itemlist.size()>0 && position == 2){
            return 2;
        }else {
            return 3;
        }
    }

    class LunViewHolder extends RecyclerView.ViewHolder{
        private Banner lunbol;
        public LunViewHolder(@NonNull View itemView) {
            super(itemView);
            lunbol = itemView.findViewById(R.id.banner);

        }
    }

    class ArtViewHolder extends RecyclerView.ViewHolder{
        private ImageView artimg;
        private TextView arttitle,artnew,artkeshi,artmoney;
        public ArtViewHolder(@NonNull View itemView) {
            super(itemView);
            artimg = itemView.findViewById(R.id.iv_kc);
            arttitle = itemView.findViewById(R.id.tv_kc_title);
            artkeshi = itemView.findViewById(R.id.tv_kc_keshi);
            artnew = itemView.findViewById(R.id.tv_kc_new);
            artmoney = itemView.findViewById(R.id.tv_kc_money);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView item_str;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            item_str = itemView.findViewById(R.id.item_str);
        }
    }

    class GonViewHolder extends RecyclerView.ViewHolder{
        private MarqueeView marqueeView;
        public GonViewHolder(@NonNull View itemView) {
            super(itemView);
            marqueeView = itemView.findViewById(R.id.marqueeView);
        }
    }
}
