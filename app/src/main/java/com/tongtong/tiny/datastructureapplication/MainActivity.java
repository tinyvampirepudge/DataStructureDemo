package com.tongtong.tiny.datastructureapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tongtong.tiny.datastructureapplication.aha.AHaArithmeticActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.LeetCodeEntryActivity;
import com.tongtong.tiny.datastructureapplication.offer.OfferEntryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Desc:    程序入口
 *
 * @author tiny
 * @date 2018/5/29 下午9:21
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_test1)
    Button btnTest1;
    @BindView(R.id.btn_test2)
    Button btnTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        AHaArithmeticActivity.actionStart(this);
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        OfferEntryActivity.actionStart(this);
    }


    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        LeetCodeEntryActivity.actionStart(this);
    }
}
