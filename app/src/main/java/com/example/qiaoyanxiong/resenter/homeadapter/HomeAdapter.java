package com.example.qiaoyanxiong.resenter.homeadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.homebean.HomeBean;
import com.example.qiaoyanxiong.resenter.homebean.UTypeBean;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {


    private Context context;
    private List<UTypeBean.ZTypeBean> list;

    public HomeAdapter(Context context, List<UTypeBean.ZTypeBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =View.inflate(context,R.layout.hometab_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
          viewHolder.textView.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_name);
        }
    }
}
