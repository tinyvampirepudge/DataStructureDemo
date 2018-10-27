package com.tongtong.tiny.datastructureapplication.leetcode.linkedlist;

/**
 * @Description: 单向链表的结点
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/27 11:00 AM
 * @Version TODO
 */
public class SingleNode {
    private int item;
    SingleNode next;

    public SingleNode(int item, SingleNode next) {
        this.item = item;
        this.next = next;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }

    @Override
    public String toString() {
        return String.valueOf(this.item);
    }
}
