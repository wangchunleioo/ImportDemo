package com.importdemolibrary;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by wang on 2018/1/22 0022.
 */

public class MyDialog {
    private static Dialog dialog;

    /**
     * 显示正在加载的dialog
     *
     * @param context 上下文
     * @param message 提示信息
     */
    public static void showDialogo(Context context, String message) {
        System.out.println("显示dialog");
        // 首先得到整个View
        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog, null);
        // 获取整个布局
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.dialog_view);
        // 页面中的Img
        ImageView img = (ImageView) view.findViewById(R.id.iv_dialog);
        // 页面中显示文本
        TextView tipText = (TextView) view.findViewById(R.id.tv_dialog);
        // 加载动画，动画用户使img图片不停的旋转
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.set_dialog);

        // 显示动画
        img.startAnimation(animation);
        // 显示文本
        tipText.setText(message);
        // 创建自定义样式的Dialog
        dialog = new Dialog(context);
        // 设置返回键无效
        dialog.setCancelable(false);
        dialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        dialog.show();
    }

    /**
     * 关闭dialog的方法
     */
    public static void dismiss() {
        if (dialog.isShowing()) {
            System.out.println("取消dialog");
            dialog.dismiss();
        }
    }
}
