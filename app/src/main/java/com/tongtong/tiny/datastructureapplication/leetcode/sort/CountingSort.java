package com.tongtong.tiny.datastructureapplication.leetcode.sort;

/**
 * @Description: 计数排序
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/23 10:13 AM
 * @Version
 */
public class CountingSort {

    /**
     * 假设数组中的数据都是非负整数
     *
     * @param a
     * @param n
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 查找数组中数据的最大值
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 创建数组c，下标大小为[0, max]
        int[] c = new int[max + 1];

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 新建数组r, 存储排序之后的结果
        int[] r = new int[n];

        // 计算排序,倒序遍历
        for (int i = n - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }


        // 将结果拷贝到a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

    /**
     * 计数排序，个人实现。
     * @param a
     * @param n
     */
    public static void countingSort1(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 查找数组中数据的最大值
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 创建数组c，下标大小为[0, max]
        int[] c = new int[max + 1];

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 新建数组r, 存储排序之后的结果
        int[] r = new int[n];

        // 计算排序,倒序遍历
        // 个人实现
        for (int i = c.length - 1; i >= 0; i--) {
            if (i > 0) {
                while (c[i] > c[i - 1]) {
                    int index = c[i] - 1;
                    r[index] = i;
                    c[i]--;
                }
            } else {
                while (c[i] > 0) {
                    int index = c[i] - 1;
                    r[index] = i;
                    c[i]--;
                }
            }
        }

        // 将结果拷贝到a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }
}
