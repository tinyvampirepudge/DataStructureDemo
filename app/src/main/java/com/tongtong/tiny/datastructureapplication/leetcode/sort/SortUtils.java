package com.tongtong.tiny.datastructureapplication.leetcode.sort;

import java.util.Random;

/**
 * @Description: 排序相关工具类
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/13 5:18 PM
 * @Version TODO
 */
public class SortUtils {
    public static int[] generateRandomArray(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(bound);
        }
        return array;
    }

    public static String getArrayToString(int[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i != a.length - 1) {
                sb.append(',');
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
