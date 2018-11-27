package com.tongtong.tiny.datastructureapplication.leetcode.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtong.tiny.datastructureapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 查找算法
 * 二分查找
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/23 10:08 PM
 * @Version
 */
public class SearchAlgorithmActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, SearchAlgorithmActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_algorithm);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        int size = 20;
        int step = 2;
        int value = 1;
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot bo lower than 0");
        }
        int[] a = SearchUtils.generateArrayWithStep(size, step);
        System.out.println("二分查找数据:" + SearchUtils.getArrayToString(a));
        int result = BinarySearch.binarySearch1(a, size, value);
        System.out.println("二分查找结果，value:" + value + ", result:" + +result);
        System.out.println();
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        int size = 20;
        int step = 3;
        int value = 3;
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot bo lower than 0");
        }
        int[] a = SearchUtils.generateArrayWithStep(size, step);
        System.out.println("二分查找数据:" + SearchUtils.getArrayToString(a));
        int result = BinarySearch.binarySearch2(a, size, value);
        System.out.println("二分查找结果，value:" + value + ", result:" + +result);
        System.out.println();
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        int value = 2;
        double precision = 1.0E-6;
        int digits = 6;
        double result = BinarySearch.sqrt(value, precision, digits);
        System.out.println("二分查找求解平方根结果，value:" + value + ", result:" + +result);
        System.out.println("二分查找求解平方根结果，value:" + value + ",precision:" + precision + ",digits:" + digits + ", \nresult:" + +result);
    }

    @OnClick(R.id.btn_test31)
    public void onBtnTest31Clicked() {
        double value = 2;
        double precision = 1.0E-6;
        int digits = 6;

        double result = BinarySearch.NewtonRaphsonSqrt(value, precision, digits);
        System.out.println("牛顿迭代法求解平方根结果，value:" + value + ",precision:" + precision + ",digits:" + digits + ", \nresult:" + +result);
    }

    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {
    }

    @OnClick(R.id.btn_test5)
    public void onBtnTest5Clicked() {
    }

    @OnClick(R.id.btn_test6)
    public void onBtnTest6Clicked() {
    }

    @OnClick(R.id.btn_test7)
    public void onBtnTest7Clicked() {
    }
}
