package com.example.imooc_pingtu.utils;

import android.content.Context;
import android.view.View;

import com.example.imooc_pingtu.AppContext;
import com.example.imooc_pingtu.view.AlertDialog;

public class AlertDialogUtils {

//   private static String title;

    public static void showPositiveButtonDialog(Context context, DialogParams params) {
        new AlertDialog(context).builder()
                .setCancelable(params.cancelable).setMsg(params.msg)
                .setTitle(params.title).setPositiveButton(params.textPostive, params.listenerPostive).show();
    }

    public static void showPositiveButtonNegativeButtonDialog(Context context, DialogParams params) {
        new AlertDialog(context).builder()
                .setCancelable(params.cancelable).setMsg(params.msg)
                .setTitle(params.title).setPositiveButton(params.textPostive, params.listenerPostive)
                .setNegativeButton(params.textNegative, params.listenerNegative)
                .show();
    }

    public static class DialogParams {
        public String msg;
        public String title;
        public String textPostive;
        public String textNegative;
        public boolean cancelable;
        public View.OnClickListener listenerPostive;
        public View.OnClickListener listenerNegative;


    }
}
