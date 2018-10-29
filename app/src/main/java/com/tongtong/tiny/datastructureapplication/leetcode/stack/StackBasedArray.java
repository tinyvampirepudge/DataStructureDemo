package com.tongtong.tiny.datastructureapplication.leetcode.stack;

import java.util.Arrays;

/**
 * @Description: 使用数组实现栈
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 10:37 AM
 * @Version TODO
 */
public class StackBasedArray implements StackInterface{

    private String[] values; // 存储栈中元素的数组
    private int capacity;// 栈的容量
    private int count;// 栈中已有数据个数

    public static void main(String[] args) {
        StackBasedArray as = new StackBasedArray(10);
        System.out.println(as);

        Boolean r1 = as.push("000");
        System.out.println(as + ",r1:" + r1);

        for (int i = 1; i < 11; i++) {
            boolean r2 = as.push("" + i + i + i);
            System.out.println(as + ",r2:" + r2);
        }

        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
        System.out.println("as.pop():" + as.pop() + "," + as);
    }

    // 初始化栈，容量确定。
    public StackBasedArray(int capacity) {
        this.values = new String[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 入栈操作
     *
     * @param value
     * @return
     */
    public Boolean push(String value) {
        // 数组空间不够了
        if (capacity == count) {
            return false;
        }
        values[count] = value;
        count++;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public String pop() {
        // 栈为空，则直接返回null
        if (0 == count) {
            return null;
        }
        String tmp = values[count - 1];
        --count;
        return tmp;
    }

    @Override
    public String toString() {
        return "StackBasedArray{" +
                "values=" + Arrays.toString(values) +
                ", capacity=" + capacity +
                ", count=" + count +
                '}';
    }
}
