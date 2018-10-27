package com.tongtong.tiny.datastructureapplication.leetcode.linkedlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

import org.w3c.dom.Node;

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
        // 单向链表反转
        SingleLinkedList sll = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            sll.add(i, i);
        }
        System.out.println(sll.toString());
        sll.reverseList();
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        // 循环链表
        SingleLinkedList sll = new SingleLinkedList();
        SingleNode head = new SingleNode(0, null);
        sll.add(head);
        for (int i = 1; i < 10; i++) {
            SingleNode node = new SingleNode(i, null);
            sll.add(node);
        }
        SingleNode sn = new SingleNode(111, null);
        sll.add(sn);
        for (int i = 10; i < 20; i++) {
            SingleNode node = new SingleNode(i, null);
            sll.add(node);
        }
        // 最后一个结点的next指向之前添加的某个结点。
        SingleNode last = new SingleNode(222, sn);
        sll.add(last);

        // 判断单向链表中是否有环
//        Boolean isCycle = sll.hasCycleByHashSet(head);
        Boolean isCycle = sll.hasCycleByTowPointers(head);
        if (isCycle) {
            System.out.println("is Cycle");
            sll.logCycle("cycle");
        } else {
            System.out.println("is not Cycle");
            System.out.println(sll.toString());
        }

    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
    }
}
