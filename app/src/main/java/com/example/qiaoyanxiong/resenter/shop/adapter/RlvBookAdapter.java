package com.example.qiaoyanxiong.resenter.shop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.shop.bean.BookDataBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvBookAdapter extends RecyclerView.Adapter<RlvBookAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BookDataBean.InfoBean> list;

    public RlvBookAdapter(Context context, ArrayList<BookDataBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_shop_book, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvBookTitle.setText(list.get(i).getName());
        String hao_ping = list.get(i).getHao_ping();
        int i1 = Integer.parseInt(hao_ping);
        viewHolder.ratingbar.setMax(i1);
        viewHolder.tvBookMoney.setText("¥"+list.get(i).getXian_price());
        Glide.with(context).load(list.get(i).getPic()).into(viewHolder.ivBook);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick != null) {
                    onClick.onClickItem(i, list.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_book)
        ImageView ivBook;
        @BindView(R.id.tv_book_hot)
        TextView tvBookHot;
        @BindView(R.id.tv_book_title)
        TextView tvBookTitle;
        @BindView(R.id.tv_book_hao)
        TextView tvBookHao;
        @BindView(R.id.ratingbar)
        RatingBar ratingbar;
        @BindView(R.id.tv_book_money)
        TextView tvBookMoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private onClick onClick;

    public void setOnClick(RlvBookAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick {
        void onClickItem(int pos, BookDataBean.InfoBean bean);
    }
}
