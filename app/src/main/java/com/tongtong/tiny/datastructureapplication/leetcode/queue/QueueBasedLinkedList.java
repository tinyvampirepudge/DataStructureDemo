package com.tongtong.tiny.datastructureapplication.leetcode.queue;

import org.w3c.dom.Node;

/**
 * @Description: 链式队列
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 3:59 PM
 * @Version TODO
 */
public class QueueBasedLinkedList implements QueueInterface {
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        // 空队列
        QueueBasedLinkedList qbll = new QueueBasedLinkedList();
        System.out.println("空队列 " + qbll);
        System.out.println();

        // 入队一个数据
        System.out.println("数据入队是否成功：" + qbll.enqueue("0000"));
        System.out.println("入队一个数据后：" + qbll);
        System.out.println();

        // 出队一个数据
        System.out.println("出队的数据是：" + qbll.dequeue());
        System.out.println("出队一个数据后：" + qbll);
        System.out.println();

        // 异常测试：从空队列中出队，看结果
        System.out.println("出队的数据是1：" + qbll.dequeue());
        System.out.println("出队一个数据后1：" + qbll);
        System.out.println();

        // 入队十条数据
        for (int i = 0; i < 10; i++) {
            System.out.println("数据入队是否成功：" + qbll.enqueue("" + i + i + i));
            System.out.println(qbll);
        }
    }

    /**
     * 入队
     *
     * @param value
     * @return
     */
    @Override
    public Boolean enqueue(String value) {
        Node newNode = new Node(value, null);

        // tail为null，表示队列中没有数据
        if (null == tail) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public String dequeue() {
        // head == null,表示队列为空。
        if (null == head) {
            return null;
        }

        // 获取数据
        String value = head.getItem();
        // 移除头结点，让head指向下一个结点。
        head = head.next;
        // 如果此时的头结点指向null，说明队列已空，需要将tail指向null.
        if (null == head) {
            tail = null;
        }

        return value;
    }

    @Override
    public String toString() {
        return "QueueBasedLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    private static class Node {
        String item;
        private Node next;

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }

        public String getItem() {
            return item;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item='" + item + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
