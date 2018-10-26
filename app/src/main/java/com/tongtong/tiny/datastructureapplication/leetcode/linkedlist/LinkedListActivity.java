package com.tongtong.tiny.datastructureapplication.leetcode.linkedlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 链表
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/26 2:17 PM
 * @Version TODO
 */
public class LinkedListActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, LinkedListActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_list);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {

    }

    private SingleLinkedList reverseSingleList(SingleLinkedList head){
        if (head == null)
            return null;

        return null;
    }


    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
    }
}
