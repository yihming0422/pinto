package com.example.imooc_pingtu.utils

import android.content.Context
import android.view.View
import com.example.imooc_pingtu.AppContext
import com.example.imooc_pingtu.view.AlertDialog


object AlertDialogUtilsKt {

    //   private static String title;


    fun showPositiveButtonDialog(context: Context,params: DialogParams) {
        AlertDialog(context).builder()
            .setCancelable(params.cancelable).setMsg(params.msg)
            .setTitle(params.title).setPositiveButton(params.textPostive, params.listenerPostive)
            .show()
    }

    fun showPositiveButtonNegativeButtonDialog(context: Context, params: DialogParams) {
        AlertDialog(context).builder()
            .setCancelable(params.cancelable).setMsg(params.msg)
            .setTitle(params.title).setPositiveButton(params.textPostive, params.listenerPostive)
            .setNegativeButton(params.textNegative, params.listenerNegative)
            .show()
    }

    class DialogParams {
        var msg: String? = null
        var title: String? = null
        var textPostive: String? = null
        var textNegative: String? = null
        var cancelable: Boolean = false
        var listenerPostive: View.OnClickListener? = null
        var listenerNegative: View.OnClickListener? = null


    }
}