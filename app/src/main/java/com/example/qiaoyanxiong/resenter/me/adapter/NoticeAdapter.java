package com.example.qiaoyanxiong.resenter.me.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.me.bean.NoticeBean;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<NoticeBean.NewsInfo> nolist = new ArrayList<>();

    public NoticeAdapter(Context context) {
        this.context = context;
    }

    public void initNoter(List<NoticeBean.NewsInfo> nolist){
        if (this.nolist != null) {
            this.nolist.addAll(nolist);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.notice_item_adapter, null);
        return new NotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        NoticeBean.NewsInfo info = nolist.get(i);
        NotViewHolder notview = (NotViewHolder) viewHolder;
        notview.nottitle.setText(info.getTitle());
        notview.nottype.setText(info.getAuthName());
        notview.nottimer.setText(info.getAddtime());
    }

    @Override
    public int getItemCount() {
        return nolist.size();
    }

    class NotViewHolder extends RecyclerView.ViewHolder{
        CircleImageView notimg;
        TextView nottype,nottimer,nottitle;
        public NotViewHolder(@NonNull View itemView) {
            super(itemView);
            notimg = itemView.findViewById(R.id.not_img);
            nottype = itemView.findViewById(R.id.not_type);
            nottimer = itemView.findViewById(R.id.not_timer);
            nottitle = itemView.findViewById(R.id.not_title);
        }
    }
}
