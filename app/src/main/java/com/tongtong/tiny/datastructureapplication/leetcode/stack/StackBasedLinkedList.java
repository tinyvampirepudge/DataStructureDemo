package com.tongtong.tiny.datastructureapplication.leetcode.stack;

import com.tongtong.tiny.datastructureapplication.leetcode.linkedlist.SingleNode;

/**
 * @Description: 使用链表实现栈
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 10:37 AM
 * @Version TODO
 */
public class StackBasedLinkedList implements StackInterface {
    private Node first;

    public static void main(String[] args) {
        StackBasedLinkedList sbll = new StackBasedLinkedList();
        System.out.println(sbll);

        // 添加数据
        for (int i = 0; i < 10; i++) {
            sbll.push("" + i + i + i);
        }
        System.out.println(sbll);

        // 获取数据
        for (int i = 0; i < 11; i++) {
            System.out.println("sbll.pop():" + sbll.pop());
        }

    }

    /**
     * 每次添加数据都向链表头结点添加。
     *
     * @param value
     * @return
     */
    @Override
    public Boolean push(String value) {
        Node newNode = new Node(value, null);
        if (null == first) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        return true;
    }

    /**
     * 每次获取数据都从链表头结点获取。
     *
     * @return
     */
    @Override
    public String pop() {
        if (null == first) {
            return null;
        } else {
            String tmp = first.getValue();
            first = first.next;
            return tmp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (first != null) {
            Node curr = first;
            while (curr != null) {
                sb.append(String.valueOf(curr));
                if (curr.next != null) {
                    sb.append(",").append(" ");
                }
                curr = curr.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node {
        Node next;
        String value;

        public Node(String value, Node next) {
            this.next = next;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
