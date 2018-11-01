package com.tongtong.tiny.datastructureapplication.leetcode.sort;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 常见的排序算法：
 * ①冒泡、插入、选择
 * ②快排、归并
 * ③桶、计数、基数
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/1 5:25 PM
 * @Version TODO
 */
public class SortAlgorithmActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, SortAlgorithmActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_algorithm);
        ButterKnife.bind(this);
    }

    public int[] generateRandomArray(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(bound);
        }
        return array;
    }

    public String getArrayToString(int[] a) {
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

    /**
     * 冒泡排序
     */
    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        int[] a = generateRandomArray(10, 100);
        System.out.println(getArrayToString(a));
        bubbleSort(a, 10);
        System.out.println(getArrayToString(a));
        System.out.println();

        int[] a1 = generateRandomArray(10, 100);
        System.out.println(getArrayToString(a1));
        bubbleSortOptimize(a1, 10);
        System.out.println(getArrayToString(a1));
    }

    /**
     * 冒泡排序
     * 两两比较，将较大的数移到后边。
     *
     * @param a
     * @param n
     */
    public void bubbleSort(int[] a, int n) {
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
    public void bubbleSortOptimize(int[] a, int n) {
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

    /**
     * 插入排序
     */
    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        int[] a = generateRandomArray(10, 100);
        System.out.println(getArrayToString(a));
        insertSort(a, 10);
        System.out.println(getArrayToString(a));
        System.out.println();
    }

    /**
     * 插入排序
     * 将数据插入到有序数组中。
     *
     * @param a
     * @param n
     */
    public void insertSort(int[] a, int n) {
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

    /**
     * 选择排序
     */
    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        int[] a = generateRandomArray(10, 100);
        System.out.println(getArrayToString(a));
        selectSort(a, 10);
        System.out.println(getArrayToString(a));
        System.out.println();
    }

    /**
     * 插入排序
     * 从未排序区间中找到最小元素，将其放到已排序区间的末尾。
     *
     * @param a
     * @param n
     */
    public void selectSort(int[] a, int n) {
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
