package com.huangwenjie.myuitils;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import cn.jake.share.frdialog.dialog.FRDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        NavigatorBarUtil.hideNavigationBarAndStatusBar(getWindow());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showHelpDialog("这是帮助信息");
                    }
                });
            }
        }).start();
    }

    public void showHelpDialog(String msg) {
        NavigatorBarUtil.focusNotAle(getWindow());
        FRDialog frDialog = new FRDialog.CommonBuilder(this)
                .setContentView(R.layout.dialog_help)
                .setText(R.id.tv_dialog_msg, msg)
//                .setOnKeyListener(dialogKeyListener)
                .setDefaultAnim()
                .show();
        NavigatorBarUtil.hideNavigationBarAndStatusBar(getWindow());
        NavigatorBarUtil.clearFocusNotAle(getWindow());
    }
}