// Generated code from Butter Knife. Do not modify!
package com.example.qiaoyanxiong.resenter.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.qiaoyanxiong.resenter.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MeFragment_ViewBinding implements Unbinder {
  private MeFragment target;

  @UiThread
  public MeFragment_ViewBinding(MeFragment target, View source) {
    this.target = target;

    target.myImage = Utils.findRequiredViewAsType(source, R.id.my_image, "field 'myImage'", ImageView.class);
    target.myHead = Utils.findRequiredViewAsType(source, R.id.my_head, "field 'myHead'", CircleImageView.class);
    target.myName = Utils.findRequiredViewAsType(source, R.id.my_name, "field 'myName'", TextView.class);
    target.myReg = Utils.findRequiredViewAsType(source, R.id.my_reg, "field 'myReg'", TextView.class);
    target.myAmend = Utils.findRequiredViewAsType(source, R.id.my_amend, "field 'myAmend'", TextView.class);
    target.myImgper = Utils.findRequiredViewAsType(source, R.id.my_imgper, "field 'myImgper'", ImageView.class);
    target.myPerson = Utils.findRequiredViewAsType(source, R.id.my_person, "field 'myPerson'", RelativeLayout.class);
    target.myImgshop = Utils.findRequiredViewAsType(source, R.id.my_imgshop, "field 'myImgshop'", ImageView.class);
    target.myShop = Utils.findRequiredViewAsType(source, R.id.my_shop, "field 'myShop'", RelativeLayout.class);
    target.myImgder = Utils.findRequiredViewAsType(source, R.id.my_imgder, "field 'myImgder'", ImageView.class);
    target.myOrder = Utils.findRequiredViewAsType(source, R.id.my_order, "field 'myOrder'", RelativeLayout.class);
    target.myImgres = Utils.findRequiredViewAsType(source, R.id.my_imgres, "field 'myImgres'", ImageView.class);
    target.myRess = Utils.findRequiredViewAsType(source, R.id.my_ress, "field 'myRess'", RelativeLayout.class);
    target.myImgcou = Utils.findRequiredViewAsType(source, R.id.my_imgcou, "field 'myImgcou'", ImageView.class);
    target.myCourse = Utils.findRequiredViewAsType(source, R.id.my_course, "field 'myCourse'", RelativeLayout.class);
    target.myImgtion = Utils.findRequiredViewAsType(source, R.id.my_imgtion, "field 'myImgtion'", ImageView.class);
    target.myEction = Utils.findRequiredViewAsType(source, R.id.my_ection, "field 'myEction'", RelativeLayout.class);
    target.myImgting = Utils.findRequiredViewAsType(source, R.id.my_imgting, "field 'myImgting'", ImageView.class);
    target.mySulting = Utils.findRequiredViewAsType(source, R.id.my_sulting, "field 'mySulting'", RelativeLayout.class);
    target.myImgstom = Utils.findRequiredViewAsType(source, R.id.my_imgstom, "field 'myImgstom'", ImageView.class);
    target.myCustom = Utils.findRequiredViewAsType(source, R.id.my_custom, "field 'myCustom'", RelativeLayout.class);
    target.myImgabout = Utils.findRequiredViewAsType(source, R.id.my_imgabout, "field 'myImgabout'", ImageView.class);
    target.myAbout = Utils.findRequiredViewAsType(source, R.id.my_about, "field 'myAbout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.myImage = null;
    target.myHead = null;
    target.myName = null;
    target.myReg = null;
    target.myAmend = null;
    target.myImgper = null;
    target.myPerson = null;
    target.myImgshop = null;
    target.myShop = null;
    target.myImgder = null;
    target.myOrder = null;
    target.myImgres = null;
    target.myRess = null;
    target.myImgcou = null;
    target.myCourse = null;
    target.myImgtion = null;
    target.myEction = null;
    target.myImgting = null;
    target.mySulting = null;
    target.myImgstom = null;
    target.myCustom = null;
    target.myImgabout = null;
    target.myAbout = null;
  }
}
