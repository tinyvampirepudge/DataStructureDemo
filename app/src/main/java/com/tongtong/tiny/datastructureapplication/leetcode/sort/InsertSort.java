package com.tongtong.tiny.datastructureapplication.leetcode.sort;

/**
 * @Description: 插入排序
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/13 5:23 PM
 * @Version TODO
 */
public class InsertSort {

    /**
     * 插入排序
     * 将数据插入到有序数组中。
     *
     * @param a
     * @param n
     */
    public static void insertSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];// 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value;// 插入数据
        }
    }
}
