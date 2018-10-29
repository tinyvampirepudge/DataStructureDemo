package com.tongtong.tiny.datastructureapplication.leetcode.queue;

import java.util.Arrays;

/**
 * @Description: 顺序队列
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 3:58 PM
 * @Version TODO
 */
public class QueueBasedArray implements QueueInterface {
    private String[] values;// 数组
    private int capacity = 0;// 数组容量
    private int head = 0;// 头部下标
    private int tail = 0;// 尾部下标

    public static void main(String[] args) {
        QueueBasedArray qba = new QueueBasedArray(10);
        System.out.println(qba);

        for (int i = 0; i < 10; i++) {
            qba.enqueue("" + i + i + i);
        }
        System.out.println(qba);

        for (int i = 0; i < 10; i++) {
            qba.dequeue();
            System.out.println(qba);
        }

        for (int i = 11; i < 20; i++) {
            qba.enqueue("" + i + i + i);
        }
        System.out.println(qba);
    }

    public QueueBasedArray(int capacity) {
        values = new String[capacity];
        this.capacity = capacity;
    }

    @Override
    public Boolean enqueue(String value) {
        // tail == capacity 表示队列末尾没有空间了
        if (tail == capacity) {
            // tail == capacity && head == 0 表示整个队列都占满了。
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; i++) {
                values[i - head] = values[i];
            }
            // 搬移完成后更新 head 和 tail
            tail -= head;
            head = 0;
        }
        values[tail] = value;
        tail++;
        return true;
    }

    @Override
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String result = values[head];
        head++;
        return result;
    }

    @Override
    public String toString() {
        return "QueueBasedArray{" +
                "values=" + Arrays.toString(values) +
                ", capacity=" + capacity +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
