package com.tongtong.tiny.datastructureapplication.leetcode.sort;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tongtong.tiny.datastructureapplication.R;

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

    /**
     * 冒泡排序
     */
    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        int[] a = SortUtils.generateRandomArray(10, 100);
        System.out.println(SortUtils.getArrayToString(a));
        BubbleSort.bubbleSort(a, 10);
        System.out.println(SortUtils.getArrayToString(a));
        System.out.println();

        int[] a1 = SortUtils.generateRandomArray(10, 100);
        System.out.println(SortUtils.getArrayToString(a1));
        BubbleSort.bubbleSortOptimize(a1, 10);
        System.out.println(SortUtils.getArrayToString(a1));
    }


    /**
     * 插入排序
     */
    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        int[] a = SortUtils.generateRandomArray(10, 100);
        System.out.println(SortUtils.getArrayToString(a));
        InsertSort.insertSort(a, 10);
        System.out.println(SortUtils.getArrayToString(a));
        System.out.println();
    }


    /**
     * 选择排序
     */
    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        int[] a = SortUtils.generateRandomArray(10, 100);
        System.out.println(SortUtils.getArrayToString(a));
        SelectSort.selectSort(a, 10);
        System.out.println(SortUtils.getArrayToString(a));
        System.out.println();
    }

    /**
     * 冒泡、插入、选择排序算法实测
     */
    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext(getSortTestResult());
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


    /**
     * 归并排序
     */
    @OnClick(R.id.btn_test5)
    public void onBtnTest5Clicked() {
        int size = 10;
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot bo lower than 0");
        }
        int[] a = SortUtils.generateRandomArray(size, 100);
        System.out.println("归并排序：");
        System.out.println(SortUtils.getArrayToString(a));
        MergeSort.mergeSort(a, size);
        System.out.println(SortUtils.getArrayToString(a));
        System.out.println();
    }

    @OnClick(R.id.btn_test6)
    public void onBtnTest6Clicked() {
        int size = 10;
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot bo lower than 0");
        }
        int[] a = SortUtils.generateRandomArray(size, 100);
        System.out.println("快速排序：");
        System.out.println(SortUtils.getArrayToString(a));
        QuickSort.quickSort(a, size);
        System.out.println(SortUtils.getArrayToString(a));
        System.out.println();
    }

    @OnClick(R.id.btn_test7)
    public void onBtnTest7Clicked() {
        int size = 20;
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot bo lower than 0");
        }
        int[] a = SortUtils.generateRandomArray(size, 10);
        System.out.println("计数排序：");
        System.out.println(SortUtils.getArrayToString(a));
        CountingSort.countingSort(a, size);
        System.out.println(SortUtils.getArrayToString(a));
        System.out.println();
    }

    /**
     * 各种算法性能比较
     *
     * @return
     */
    private String getSortTestResult() {
        return getSortTestResultWithBounds(10000);
    }

    /**
     * 各种算法性能比较
     *
     * @param bounds
     * @return
     */
    private String getSortTestResultWithBounds(int bounds) {
        System.out.println("getSortTestResult Thread.currentThread():" + Thread.currentThread());
        int size = 50000;
        int[] a = SortUtils.generateRandomArray(size, bounds);

        int[] a1 = new int[size];
        System.arraycopy(a, 0, a1, 0, a.length);
        long startTime1 = System.currentTimeMillis();
        BubbleSort.bubbleSort(a1, size);
        long endTime1 = System.currentTimeMillis();
        String result1 = "冒泡排序开始时间:" + startTime1 + ",结束时间:" + endTime1 + ",总耗时:" + (endTime1 - startTime1);
        System.out.println(result1);
        System.out.println();

        int[] a2 = new int[size];
        System.arraycopy(a, 0, a2, 0, a.length);
        long startTime2 = System.currentTimeMillis();
        InsertSort.insertSort(a2, size);
        long endTime2 = System.currentTimeMillis();
        String result2 = "插入排序开始时间:" + startTime2 + ",结束时间:" + endTime2 + ",总耗时:" + (endTime2 - startTime2);
        System.out.println(result2);
        System.out.println();

        int[] a3 = new int[size];
        System.arraycopy(a, 0, a3, 0, a.length);
        long startTime3 = System.currentTimeMillis();
        SelectSort.selectSort(a3, size);
        long endTime3 = System.currentTimeMillis();
        String result3 = "选择排序开始时间:" + startTime3 + ",结束时间:" + endTime3 + ",总耗时:" + (endTime3 - startTime3);
        System.out.println(result3);
        System.out.println();

        int[] a4 = new int[size];
        System.arraycopy(a, 0, a4, 0, a.length);
        long startTime4 = System.currentTimeMillis();
        MergeSort.mergeSort(a4, size);
        long endTime4 = System.currentTimeMillis();
        String result4 = "归并排序开始时间:" + startTime4 + ",结束时间:" + endTime4 + ",总耗时:" + (endTime4 - startTime4);
        System.out.println(result4);
        System.out.println();

        int[] a5 = new int[size];
        System.arraycopy(a, 0, a5, 0, a.length);
        long startTime5 = System.currentTimeMillis();
        QuickSort.quickSort(a5, size);
        long endTime5 = System.currentTimeMillis();
        String result5 = "快速排序开始时间:" + startTime5 + ",结束时间:" + endTime5 + ",总耗时:" + (endTime5 - startTime5);
        System.out.println(result5);
        System.out.println();

        return "随机数数组大小为:" + size + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5;
    }

}
