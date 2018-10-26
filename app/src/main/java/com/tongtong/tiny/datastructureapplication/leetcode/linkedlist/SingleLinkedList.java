package com.tongtong.tiny.datastructureapplication.leetcode.linkedlist;

import org.w3c.dom.Node;

/**
 * @Description: 单链表，提供简单的增删改查方法，不考虑并发情况。
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/26 2:38 PM
 * @Version TODO
 */
public class SingleLinkedList {

    private int size = 0;
    private Node first = null;

    /**
     * 增删改查方法
     * add(index, E)
     * remove(index)
     * set(index, E)
     * get(index)
     */

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            sll.add(i, i);
        }
        sll.add(11,100);
        System.out.println(sll.toString());
    }

    /**
     * 在角标为index的位置插入数据
     *
     * @param index
     * @param value
     * @return
     */
    public boolean add(int index, int value) {
        if (index < 0) {
            throw new IllegalArgumentException("index cannot be less than 0!");
        }

        if (getSize() < index) {
            return false;
        }

        if (index == 0) {
            if (first == null) {
                first = new Node(value, null);
            } else {
                Node next = get(0);
                Node node = new Node(value, next);
                first = node;
            }
        } else {
            Node prev = get(index - 1);
            Node node = new Node(value, prev.next);
            prev.next = node;
        }
        size++;
        return true;
    }

    public boolean remove(int index) {
        return true;
    }

    public boolean set(int index, int value) {
        return true;
    }

    /**
     * 获取角标上的数据。
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index cannot be less than 0!");
        }

        if (getSize() <= index) {
            return null;
        }

        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (first != null) {
            Node curr = first;
            while (curr != null) {
                sb.append(String.valueOf(curr));
                if (curr.next!=null){
                    sb.append(",").append(" ");
                }
                curr = curr.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node {
        private int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(this.item);
        }
    }

}
