package com.tongtong.tiny.datastructureapplication.leetcode.sort;

/**
 * @Description: 冒泡排序
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/13 5:22 PM
 * @Version TODO
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * 两两比较，将较大的数移到后边。
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // 交换条件
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 优化后的冒泡排序
     *
     * @param a
     * @param n
     */
    public static void bubbleSortOptimize(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) break;
        }
    }
}
