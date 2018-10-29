package com.tongtong.tiny.datastructureapplication.leetcode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;
import com.tongtong.tiny.datastructureapplication.leetcode.linkedlist.LinkedListActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.queue.QueueActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.stack.StackActivity;

/**
 * @Description: LeetCode练习
 * https://leetcode.com/problemset/all/
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/26 2:11 PM
 * @Version TODO
 */import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeetCodeEntryActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, LeetCodeEntryActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leet_code_entry);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        LinkedListActivity.actionStart(this);
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        StackActivity.actionStart(this);
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        QueueActivity.actionStart(this);
    }
}
