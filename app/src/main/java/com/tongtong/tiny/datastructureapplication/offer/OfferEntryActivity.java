package com.tongtong.tiny.datastructureapplication.offer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tongtong.tiny.datastructureapplication.R;
import com.tongtong.tiny.datastructureapplication.offer.chapter01.OfferChapter01Activity;
import com.tongtong.tiny.datastructureapplication.offer.chapter02.OfferChapter02Activity;
import com.tongtong.tiny.datastructureapplication.offer.chapter03.OfferChapter03Activity;
import com.tongtong.tiny.datastructureapplication.offer.chapter04.OfferChapter04Activity;
import com.tongtong.tiny.datastructureapplication.offer.chapter05.OfferChapter05Activity;
import com.tongtong.tiny.datastructureapplication.offer.chapter06.OfferChapter06Activity;
import com.tongtong.tiny.datastructureapplication.offer.chapter07.OfferChapter07Activity;
import com.tongtong.tiny.datastructureapplication.offer.chapter08.OfferChapter08Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Desc: 剑指offer
 *
 * @author tiny
 * @date 2018/6/1 下午6:43
 */
public class OfferEntryActivity extends AppCompatActivity {
    @BindView(R.id.btn_test1)
    Button btnTest1;
    @BindView(R.id.btn_test2)
    Button btnTest2;
    @BindView(R.id.btn_test3)
    Button btnTest3;
    @BindView(R.id.btn_test4)
    Button btnTest4;
    @BindView(R.id.btn_test5)
    Button btnTest5;
    @BindView(R.id.btn_test6)
    Button btnTest6;
    @BindView(R.id.btn_test7)
    Button btnTest7;
    @BindView(R.id.btn_test8)
    Button btnTest8;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferEntryActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_entry);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        OfferChapter01Activity.actionStart(this);
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        OfferChapter02Activity.actionStart(this);
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        OfferChapter03Activity.actionStart(this);
    }

    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
        OfferChapter04Activity.actionStart(this);
    }

    @OnClick(R.id.btn_test5)
    public void onBtnTest5Clicked() {
        OfferChapter05Activity.actionStart(this);
    }

    @OnClick(R.id.btn_test6)
    public void onBtnTest6Clicked() {
        OfferChapter06Activity.actionStart(this);
    }

    @OnClick(R.id.btn_test7)
    public void onBtnTest7Clicked() {
        OfferChapter07Activity.actionStart(this);
    }

    @OnClick(R.id.btn_test8)
    public void onBtnTest8Clicked() {
        OfferChapter08Activity.actionStart(this);
    }
}
