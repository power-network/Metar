// Generated code from Butter Knife. Do not modify!
package com.example.qiaoyanxiong.resenter.shop.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.qiaoyanxiong.resenter.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RlvKeChengAdapter$ViewHolder_ViewBinding implements Unbinder {
  private RlvKeChengAdapter.ViewHolder target;

  @UiThread
  public RlvKeChengAdapter$ViewHolder_ViewBinding(RlvKeChengAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.ivKc = Utils.findRequiredViewAsType(source, R.id.iv_kc, "field 'ivKc'", ImageView.class);
    target.tvKcTitle = Utils.findRequiredViewAsType(source, R.id.tv_kc_title, "field 'tvKcTitle'", TextView.class);
    target.tvKcNew = Utils.findRequiredViewAsType(source, R.id.tv_kc_new, "field 'tvKcNew'", TextView.class);
    target.tvKcKeshi = Utils.findRequiredViewAsType(source, R.id.tv_kc_keshi, "field 'tvKcKeshi'", TextView.class);
    target.tvKcmoney = Utils.findRequiredViewAsType(source, R.id.tv_kc_money, "field 'tvKcmoney'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RlvKeChengAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivKc = null;
    target.tvKcTitle = null;
    target.tvKcNew = null;
    target.tvKcKeshi = null;
    target.tvKcmoney = null;
  }
}
