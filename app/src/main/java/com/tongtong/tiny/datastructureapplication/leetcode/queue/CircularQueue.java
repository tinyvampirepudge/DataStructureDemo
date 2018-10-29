package com.tongtong.tiny.datastructureapplication.leetcode.queue;

import java.util.Arrays;

/**
 * @Description: 循环队列
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 8:20 PM
 * @Version TODO
 */
public class CircularQueue implements QueueInterface {
    private String[] values;// 容器
    private int capacity = 0;// 容量
    // head 表示队头下标，tail表示对尾下标
    private int head = 0;
    private int tail = 0;

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(10);
        System.out.println(cq);
        System.out.println();

        //正常添加的数据
        System.out.println("正常添加的数据:");
        for (int i = 0; i < 9; i++) {
            System.out.println("cq.enqueue():" + cq.enqueue("" + i + i + i));
            System.out.println(cq);
        }
        System.out.println();

        // 队列满了以后添加数据
        System.out.println("队列满了以后添加数据:");
        System.out.println("cq.enqueue():" + cq.enqueue("aaa"));
        System.out.println(cq);
        System.out.println();

        // 清空队列
        System.out.println("清空队列:");
        for (int i = 0; i < 9; i++) {
            System.out.println("cq.dequeue():" + cq.dequeue());
            System.out.println(cq);
        }
        System.out.println();

        // 队列清空以后，继续清空
        System.out.println("队列清空以后，继续清空:");
        System.out.println("cq.dequeue():" + cq.dequeue());
        System.out.println(cq);
    }

    public CircularQueue(int capacity) {
        values = new String[capacity];
        this.capacity = capacity;
    }

    @Override
    public Boolean enqueue(String value) {
        // 队列满了
        if ((tail + 1) % capacity == head) {
            return false;
        }
        values[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    @Override
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = values[head];
        head = (head + 1) % capacity;
        return ret;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "values=" + Arrays.toString(values) +
                ", capacity=" + capacity +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
