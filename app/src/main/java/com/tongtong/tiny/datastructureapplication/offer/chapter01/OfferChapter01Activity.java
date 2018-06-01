package com.tongtong.tiny.datastructureapplication.offer.chapter01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;
/**
 * Desc: 第一章 面试的流程
 *
 * @author tiny
 * @date 2018/6/1 下午6:51
 */
public class OfferChapter01Activity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferChapter01Activity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter01);
    }
}
