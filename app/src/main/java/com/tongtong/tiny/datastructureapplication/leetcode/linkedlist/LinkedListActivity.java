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
        // 合并两个有序链表
        SingleLinkedList sll1 = new SingleLinkedList();
        for (int i = 0; i < 10; i += 2) {
            SingleNode node = new SingleNode(i, null);
            sll1.add(node);
        }
        System.out.println("单向链表1：" + sll1.toString());

        SingleLinkedList sll2 = new SingleLinkedList();
        for (int i = 1; i < 12; i += 2) {
            SingleNode node = new SingleNode(i, null);
            sll2.add(node);
        }
        System.out.println("单向链表2：" + sll2.toString());

        SingleNode mergedNode = mergeTwoLists(sll1.getFirst(), sll2.getFirst());
        sll1.logFromHead("mergedNode", mergedNode);
    }

    public SingleNode mergeTwoLists(SingleNode l1, SingleNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        SingleNode mergedNode;
        if (l1.getItem() < l2.getItem()) {
            mergedNode = l1;
            mergedNode.next = mergeTwoLists(l1.next, l2);
        } else {
            mergedNode = l2;
            mergedNode.next = mergeTwoLists(l2.next, l1);
        }
        return mergedNode;
    }

    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
        // 移除链表倒数第n个结点
        SingleLinkedList sll = new SingleLinkedList();
        for (int i = 0; i < 5; i++) {
            sll.addLast(i + 1);
        }
        System.out.println(sll.toString());
//        SingleNode node1 = removeNthFromEnd1(sll.getFirst(), 2);
//        sll.logFromHead("removeNthFromEnd1", node1);

        SingleNode node2 = removeNthFromEnd2(sll.getFirst(), 2);
        sll.logFromHead("removeNthFromEnd2", node2);
    }

    /**
     * 移除链表倒数第n个结点，先遍历获取链表长度，接着获取要移除的前一个元素，修改该元素的node.next --> node.next.next。
     *
     * @param head
     * @param n
     * @return
     */
    public SingleNode removeNthFromEnd1(SingleNode head, int n) {
        SingleNode dummy = new SingleNode(0, head);

        //获取链表长度
        int length = 0;
        SingleNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        // 找到角标为(length - n - 1)的结点，让其next指向下下一个结点。
        first = head;
        int index = 0;
        while (index < length - n - 1) {
            first = first.next;
            index++;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * 移除链表倒数第n个结点，使用两个指针实现。
     *
     * @param head
     * @param n
     * @return
     */
    public SingleNode removeNthFromEnd2(SingleNode head, int n) {
        SingleNode dummy = new SingleNode(0, head);
        SingleNode left = dummy;
        SingleNode right = dummy;
        for (int i = 0; i <= n; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

    @OnClick(R.id.btn_test5)
    public void onBtnTest5Clicked() {
        // 求单向链表的中间结点
        SingleLinkedList sll1 = new SingleLinkedList();
        for (int i = 1; i < 10; i++) {
            SingleNode node = new SingleNode(i, null);
            sll1.add(node);
        }
        System.out.println(sll1.toString());

        SingleNode node1 = middleNodeByArrays(sll1.getFirst());
        sll1.logFromHead("middleNodeByArrays1", node1);

//        SingleNode node1 = middleNodeByTwoPointers(sll1.getFirst());
//        sll1.logFromHead("middleNodeByTwoPointers1", node1);

        SingleLinkedList sll2 = new SingleLinkedList();
        for (int i = 1; i < 11; i++) {
            SingleNode node = new SingleNode(i, null);
            sll2.add(node);
        }
        System.out.println(sll2.toString());

        SingleNode node2 = middleNodeByArrays(sll2.getFirst());
        sll2.logFromHead("middleNodeByArrays2", node2);

//        SingleNode node2 = middleNodeByTwoPointers(sll2.getFirst());
//        sll2.logFromHead("middleNodeByTwoPointers2", node2);
    }

    /**
     * 求单向链表的中间结点，使用快慢指针实现
     *
     * @param head
     * @return
     */
    public SingleNode middleNodeByTwoPointers(SingleNode head) {
        SingleNode slow = head;
        SingleNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 求单向链表的中间结点，使用数组实现
     *
     * @param head
     * @return
     */
    public SingleNode middleNodeByArrays(SingleNode head) {
        SingleNode[] arrays = new SingleNode[100];
        int count = 0;
        while (head != null) {
            arrays[count] = head;
            count++;
            head = head.next;
        }
        return arrays[count / 2];
    }
}
