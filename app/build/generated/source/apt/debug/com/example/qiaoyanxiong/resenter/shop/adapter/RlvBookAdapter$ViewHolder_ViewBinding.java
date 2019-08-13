// Generated code from Butter Knife. Do not modify!
package com.example.qiaoyanxiong.resenter.shop.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.qiaoyanxiong.resenter.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RlvBookAdapter$ViewHolder_ViewBinding implements Unbinder {
  private RlvBookAdapter.ViewHolder target;

  @UiThread
  public RlvBookAdapter$ViewHolder_ViewBinding(RlvBookAdapter.ViewHolder target, View source) {
    this.target = target;

    target.ivBook = Utils.findRequiredViewAsType(source, R.id.iv_book, "field 'ivBook'", ImageView.class);
    target.tvBookHot = Utils.findRequiredViewAsType(source, R.id.tv_book_hot, "field 'tvBookHot'", TextView.class);
    target.tvBookTitle = Utils.findRequiredViewAsType(source, R.id.tv_book_title, "field 'tvBookTitle'", TextView.class);
    target.tvBookHao = Utils.findRequiredViewAsType(source, R.id.tv_book_hao, "field 'tvBookHao'", TextView.class);
    target.ratingbar = Utils.findRequiredViewAsType(source, R.id.ratingbar, "field 'ratingbar'", RatingBar.class);
    target.tvBookMoney = Utils.findRequiredViewAsType(source, R.id.tv_book_money, "field 'tvBookMoney'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RlvBookAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivBook = null;
    target.tvBookHot = null;
    target.tvBookTitle = null;
    target.tvBookHao = null;
    target.ratingbar = null;
    target.tvBookMoney = null;
  }
}
