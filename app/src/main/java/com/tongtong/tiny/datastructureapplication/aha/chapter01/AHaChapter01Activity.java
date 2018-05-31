package com.tongtong.tiny.datastructureapplication.aha.chapter01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tongtong.tiny.datastructureapplication.R;
import com.tongtong.tiny.datastructureapplication.util.LogUtils;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Desc: 啊哈算法 第一章，排序
 *
 * @author tiny
 * @date 2018/5/29 下午9:25
 */
public class AHaChapter01Activity extends AppCompatActivity {

    @BindView(R.id.btn_test1)
    Button btnTest1;
    @BindView(R.id.btn_test2)
    Button btnTest2;
    @BindView(R.id.btn_test3)
    Button btnTest3;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, AHaChapter01Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aha_chapter01);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        sort1();
    }

    /**
     * 简单的桶排序
     * 对一组0~10的数据进行排序。
     */
    private void sort1() {
        Random random = new Random();
        //prepare data
        int[] inputs = new int[10];
        for (int j = 0; j < inputs.length; j++) {
            inputs[j] = random.nextInt(10);
        }
        for (Integer inte : inputs) {
            LogUtils.e("inputs:" + inte);
        }

        int[] books = new int[11];
        for (int m = 0; m < inputs.length; m++) {
            books[inputs[m]]++;
        }
        for (int j = 0; j < books.length; j++) {
            LogUtils.e("books[" + j + "]:" + books[j]);
        }
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        sort2();
    }

    /**
     * 冒泡排序，升序。
     */
    private void sort2() {
        int n = 10;
        Random random = new Random();
        //prepare data
        int[] inputs = new int[n];
        for (int j = 0; j < inputs.length; j++) {
            inputs[j] = random.nextInt(n);
        }
        for (Integer inte : inputs) {
            LogUtils.e("inputs:" + inte);
        }
        //冒泡排序的核心部分
        //n个数排序，只用进行n-1趟
        for (int j = 1; j <= n - 1; j++) {
            //从第1位开始比较知道最后一个尚未归为的数，想想为什么到n-1就可以了。
            for (int m = 0; m < n - j; m++) {
                if (inputs[m] > inputs[m + 1]) {
                    int temp = inputs[m];
                    inputs[m] = inputs[m + 1];
                    inputs[m + 1] = temp;
                }
            }
        }
        for (Integer inte : inputs) {
            LogUtils.e("result inputs:" + inte);
        }
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        int n = 100;
        Random random = new Random();
        //prepare data
        for (int j = 1; j <= n; j++) {
            a[j] = random.nextInt(n + 1);
        }
        StringBuilder sbInputs = new StringBuilder();
        sbInputs.append("inputs:");
        for (Integer inte : a) {
            sbInputs.append(inte).append(",");
        }
        LogUtils.e(sbInputs.toString());

        quickSort(1, n);

        StringBuilder sbResults = new StringBuilder();
        sbResults.append("sbResults:");
        for (Integer inte : a) {
            sbResults.append(inte).append(",");
        }
        LogUtils.e(sbResults.toString());
    }

    private int[] a = new int[101];

    /**
     * 快速排序
     *
     * @param left  左边哨兵的位置
     * @param right 右边哨兵的位置
     */
    private void quickSort(int left, int right) {
        int i, j, t, temp;
        if (left > right) {
            return;
        }

        temp = a[left];//temp中存的就是基准数
        i = left;
        j = right;
        while (i != j) {
            //顺序很重要，要先从右往左找
            while (a[j] >= temp && i < j) {
                j--;
            }

            while (a[i] <= temp && i < j) {
                i++;
            }

            //交换两个数在数组中的位置
            if (i < j) {//当哨兵i和哨兵j没有相遇时
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        //最终将基准数归位
        a[left] = a[i];
        a[i] = temp;

        quickSort(left, i - 1);//继续处理左边的，这里是一个递归的过程。
        quickSort(i + 1, right);//继续处理右边的，这里是一个递归的过程。
    }
}
