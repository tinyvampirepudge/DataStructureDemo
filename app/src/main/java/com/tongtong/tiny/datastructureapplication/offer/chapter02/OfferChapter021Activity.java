package com.tongtong.tiny.datastructureapplication.offer.chapter02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tongtong.tiny.datastructureapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Desc: 面试题2：实现Singleton模式
 *
 * @author tiny
 * @date 2018/6/1 下午11:29
 */
public class OfferChapter021Activity extends AppCompatActivity {

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
        Intent starter = new Intent(context, OfferChapter021Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter021);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        Singleton1 singleton1 = Singleton1.getInstance();
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        Singleton2 singleton2 = Singleton2.getInstance();
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        Singleton3 singleton3 = Singleton3.getInstance();
    }

    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
        Singleton4 singleton4 = Singleton4.getSingleton();
    }

    @OnClick(R.id.btn_test5)
    public void onBtnTest5Clicked() {
        Singleton5 singleton5 = Singleton5.getInstance();
    }

    @OnClick(R.id.btn_test6)
    public void onBtnTest6Clicked() {
        Singleton6 singleton6 = Singleton6.getInstance();
    }

    @OnClick(R.id.btn_test7)
    public void onBtnTest7Clicked() {
    }

    @OnClick(R.id.btn_test8)
    public void onBtnTest8Clicked() {
    }
}
