package com.tongtong.tiny.datastructureapplication.offer.chapter06;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;
/**
 * Desc: 第六章 面试中的各项能力
 *
 * @author tiny
 * @date 2018/6/1 下午7:02
 */
public class OfferChapter06Activity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferChapter06Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter06);
    }
}
