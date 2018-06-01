package com.tongtong.tiny.datastructureapplication.offer.chapter04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;
/**
 * Desc: 第四章 解决面试提的思路
 *
 * @author tiny
 * @date 2018/6/1 下午6:55
 */
public class OfferChapter04Activity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferChapter04Activity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter04);
    }
}
