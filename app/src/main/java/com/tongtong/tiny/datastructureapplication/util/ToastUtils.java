package com.tongtong.tiny.datastructureapplication.util;

import android.widget.Toast;

import com.tongtong.tiny.datastructureapplication.app.MyApplication;


/**
 * Created by tiny on 16/7/30.
 */
public class ToastUtils {

    private static Toast toast;//简单的toast

    /**
     * 单例toast,测试用
     *
     * @param content
     */
    public static void showSingleToast(String content) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getInstance(), content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
