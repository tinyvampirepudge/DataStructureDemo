package com.tongtong.tiny.datastructureapplication.leetcode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;
import com.tongtong.tiny.datastructureapplication.leetcode.hash.HashAlgorithmTest;
import com.tongtong.tiny.datastructureapplication.leetcode.linkedlist.LinkedListActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.queue.QueueActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.search.SearchAlgorithmActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.sort.SortAlgorithmActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.stack.StackActivity;
import com.tongtong.tiny.datastructureapplication.leetcode.tree.BinaryTreeActivity;

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

    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
        SortAlgorithmActivity.actionStart(this);
    }

    @OnClick(R.id.btn_test5)
    public void onBtnTest5Clicked() {
        SearchAlgorithmActivity.actionStart(this);
    }

    @OnClick(R.id.btn_test6)
    public void onBtnTest6Clicked() {
        HashAlgorithmTest.main(null);
    }

    @OnClick(R.id.btn_test7)
    public void onBtnTest7Clicked() {
        BinaryTreeActivity.actionStart(this);
    }
}
