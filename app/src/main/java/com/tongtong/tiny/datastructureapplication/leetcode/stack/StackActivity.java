package com.tongtong.tiny.datastructureapplication.leetcode.stack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 栈相关操作
 *
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 10:36 AM
 * @Version TODO
 */
public class StackActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, StackActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        // 自定义顺序栈
        StackBasedArray.main(null);
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        // 自定义链表栈
        StackBasedLinkedList.main(null);
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
    }
}
