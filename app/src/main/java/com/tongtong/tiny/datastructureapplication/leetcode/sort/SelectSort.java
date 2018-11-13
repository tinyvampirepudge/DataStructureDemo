package com.tongtong.tiny.datastructureapplication.leetcode.sort;

/**
 * @Description: 选择排序
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/13 5:25 PM
 * @Version TODO
 */
public class SelectSort {
    /**
     * 插入排序
     * 从未排序区间中找到最小元素，将其放到已排序区间的末尾。
     *
     * @param a
     * @param n
     */
    public static void selectSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            // 查找最小值的角标
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 减少无用的交换。
            if (minIndex == i) {
                continue;
            }

            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

}
