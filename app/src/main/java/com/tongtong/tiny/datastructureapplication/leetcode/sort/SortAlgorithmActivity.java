package com.tongtong.tiny.datastructureapplication.leetcode.sort;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tongtong.tiny.datastructureapplication.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
    @BindView(R.id.tv_sort_result1)
    TextView tv1;

    @BindView(R.id.tv_sort_result2)
    TextView tv2;

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

    /**
     * 冒泡、插入、选择排序算法实测
     */
    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext(getSortTestResult1());
            emitter.onComplete();
        })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext s:" + s);
                        tv1.setText(s);
                        System.out.println("onNext Thread.currentThread():" + Thread.currentThread());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

    }

    private String getSortTestResult1() {
        System.out.println("getSortTestResult1 Thread.currentThread():" + Thread.currentThread());
        int size = 50000;
        int[] a = generateRandomArray(size, 10000);

        int[] a1 = new int[size];
        System.arraycopy(a, 0, a1, 0, a.length);
        int[] a2 = new int[size];
        System.arraycopy(a, 0, a2, 0, a.length);
        int[] a3 = new int[size];
        System.arraycopy(a, 0, a3, 0, a.length);

        long startTime1 = System.currentTimeMillis();
        bubbleSort(a1, size);
        long endTime1 = System.currentTimeMillis();
        String result1 = "冒泡排序开始时间:" + startTime1 + ",结束时间:" + endTime1 + ",总耗时:" + (endTime1 - startTime1);
        System.out.println(result1);
        System.out.println();

        long startTime2 = System.currentTimeMillis();
        insertSort(a2, size);
        long endTime2 = System.currentTimeMillis();
        String result2 = "插入排序开始时间:" + startTime2 + ",结束时间:" + endTime2 + ",总耗时:" + (endTime2 - startTime2);
        System.out.println(result2);
        System.out.println();

        long startTime3 = System.currentTimeMillis();
        selectSort(a3, size);
        long endTime3 = System.currentTimeMillis();
        String result3 = "选择排序开始时间:" + startTime3 + ",结束时间:" + endTime3 + ",总耗时:" + (endTime3 - startTime3);
        System.out.println(result3);
        System.out.println();

        return "随机数数组大小为:" + size + "\n" + result1 + "\n" + result2 + "\n" + result3;
    }

    /**
     * 归并排序
     */
    @OnClick(R.id.btn_test5)
    public void onBtnTest5Clicked() {
        int size = 10;
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot bo lower than 0");
        }
        int[] a = generateRandomArray(size, 100);
        System.out.println("归并排序：");
        System.out.println(getArrayToString(a));
        mergeSort(a, size);
        System.out.println(getArrayToString(a));
        System.out.println();
    }

    /**
     * 归并排序
     *
     * @param a 待排序的数组
     * @param n 数组大小
     */
    public void mergeSort(int[] a, int n) {
        mergeSortRecursion(a, 0, n - 1);
    }

    /**
     * 递归调用的函数
     *
     * @param a
     * @param p
     * @param r
     */
    public void mergeSortRecursion(int[] a, int p, int r) {
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
    public void merge(int[] a, int p, int q, int r) {
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
