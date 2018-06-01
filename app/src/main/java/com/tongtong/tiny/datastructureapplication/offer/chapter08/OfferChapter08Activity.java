package com.tongtong.tiny.datastructureapplication.offer.chapter08;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

/**
 * Desc: 第八章 英文版新增面试题
 *
 * @author tiny
 * @date 2018/6/1 下午7:02
 */
public class OfferChapter08Activity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferChapter08Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter08);
    }
}
