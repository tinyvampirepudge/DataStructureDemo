package com.tongtong.tiny.datastructureapplication.offer.chapter03;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;
/**
 * Desc: 第三章 高质量的代码
 *
 * @author tiny
 * @date 2018/6/1 下午6:53
 */
public class OfferChapter03Activity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferChapter03Activity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter03);
    }
}
