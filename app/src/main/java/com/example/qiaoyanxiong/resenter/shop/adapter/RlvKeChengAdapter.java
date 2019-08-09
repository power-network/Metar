package com.example.qiaoyanxiong.resenter.shop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.shop.bean.KeChengDataBean;
import com.example.qiaoyanxiong.resenter.shop.bean.KechengBean;
import com.example.qiaoyanxiong.resenter.utils.UnicodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvKeChengAdapter extends RecyclerView.Adapter<RlvKeChengAdapter.ViewHolder> {

    private Context context;
    private List<KeChengDataBean.InfoBean.KechengBean> list;

    public String name;
    public String name1;

    public RlvKeChengAdapter(Context context,   List<KeChengDataBean.InfoBean.KechengBean> list
    ) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_shop_kecheng, null);
        return new ViewHolder(view);
    }

    private static final String TAG = "RlvKeChengAdapter";

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        KeChengDataBean.InfoBean.KechengBean kechengBean = list.get(i);
        name = kechengBean.getName();
        Log.e(TAG, "onBindViewHolder: " + name);
        name1 = UnicodeUtils.decode(name);
        Log.e(TAG, "onBindViewHolder: " + name1);
        viewHolder.tvKcTitle.setText(UnicodeUtils.decode(list.get(i).getName()));
        viewHolder.tvKcKeshi.setText(kechengBean.getClass_hour());
        viewHolder.tvKcmoney.setText("¥" + kechengBean.getJia_ge());
        Glide.with(context).load(list.get(i).getPic()).into(viewHolder.ivKc);
        if (kechengBean.getType_str().size() > 0) {
            String news = kechengBean.getType_str().get(0);
            String news1 = UnicodeUtils.decode(news);
            viewHolder.tvKcNew.setVisibility(View.VISIBLE);
            viewHolder.tvKcNew.setText(news1);
        } else {
            viewHolder.tvKcNew.setVisibility(View.GONE);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClik != null) {
                    onClik.onItemClick(i, list.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_kc)
        ImageView ivKc;
        @BindView(R.id.tv_kc_title)
        TextView tvKcTitle;
        @BindView(R.id.tv_kc_new)
        TextView tvKcNew;
        @BindView(R.id.tv_kc_keshi)
        TextView tvKcKeshi;
        @BindView(R.id.tv_kc_money)
        TextView tvKcmoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private onClik onClik;

    public void setOnClik(RlvKeChengAdapter.onClik onClik) {
        this.onClik = onClik;
    }

    public interface onClik {
        void onItemClick(int pos, KeChengDataBean.InfoBean.KechengBean bean);
    }
}
