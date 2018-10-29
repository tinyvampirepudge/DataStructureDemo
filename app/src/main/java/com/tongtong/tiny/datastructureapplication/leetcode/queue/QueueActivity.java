package com.tongtong.tiny.datastructureapplication.leetcode.queue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 队列
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 3:53 PM
 * @Version TODO
 */
public class QueueActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, QueueActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        ButterKnife.bind(this);
    }

    /**
     * 顺序队列
     */
    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        QueueBasedArray.main(null);
    }

    /**
     * 链式队列
     */
    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        QueueBasedLinkedList.main(null);
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
    }

    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
    }
}
