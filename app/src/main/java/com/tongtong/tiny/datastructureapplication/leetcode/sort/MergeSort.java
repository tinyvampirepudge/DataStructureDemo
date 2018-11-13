package com.tongtong.tiny.datastructureapplication.leetcode.sort;

/**
 * @Description: 归并排序
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/13 5:20 PM
 * @Version TODO
 */
public class MergeSort {
    /**
     * 归并排序
     *
     * @param a 待排序的数组
     * @param n 数组大小
     */
    public static void mergeSort(int[] a, int n) {
        mergeSortRecursion(a, 0, n - 1);
    }

    /**
     * 递归调用的函数
     *
     * @param a
     * @param p
     * @param r
     */
    public static void mergeSortRecursion(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的位置q
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortRecursion(a, p, q);
        mergeSortRecursion(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * 合并两个有序数组
     *
     * @param a 合并好的有序数组，需要放到这个位置上。
     * @param p
     * @param q
     * @param r
     */
    public static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];

        // 最少把一个数组中的数据取完。
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据。
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据copy到临时数组 tmp。
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将 tmp 中的数据拷贝回 a 中
        System.arraycopy(tmp, 0, a, p, r - p + 1);
    }
}
