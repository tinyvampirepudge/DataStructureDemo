package com.tongtong.tiny.datastructureapplication.offer.chapter07;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

/**
 * Desc: 第七章 两个面试案例
 *
 * @author tiny
 * @date 2018/6/1 下午7:01
 */
public class OfferChapter07Activity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferChapter07Activity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter07);
    }
}
