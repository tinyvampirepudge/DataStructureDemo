package com.tongtong.tiny.datastructureapplication.offer.chapter02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tongtong.tiny.datastructureapplication.R;
import com.tongtong.tiny.datastructureapplication.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Desc: 面试题3：二维数组中的查找
 *
 * @author tiny
 * @date 2018/6/2 下午1:12
 */
public class OfferChapter022Activity extends AppCompatActivity {

    @BindView(R.id.btn_test1)
    Button btnTest1;
    @BindView(R.id.btn_test2)
    Button btnTest2;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OfferChapter022Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_chapter022);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        int startNumber = 5;
        int rowSize = 5;
        int columnSize = 6;
        int rowStep = 2;
        int columnStep = 3;
        int[][] arrays = generateDoubleDimensionalArray(startNumber, rowSize, columnSize, rowStep, columnStep);

        StringBuffer sb = new StringBuffer();
        for (int m = 0; m < rowSize; m++) {
            for (int n = 0; n < columnSize; n++) {
                sb.append(String.valueOf(arrays[m][n])).append(",");
            }
            sb.append("\n");
        }
        LogUtils.e("二维数组为:" + sb.toString());

        int targetNumber = 6;
        boolean result = findFromTopRight(arrays, targetNumber);
        LogUtils.e(String.valueOf(targetNumber) + "的查询结果为:" + result);
    }

    /**
     * 从右上角查找
     *
     * @param arrays       二维有序数组
     * @param targetNumber 待查找的数字
     * @return
     */
    private boolean findFromTopRight(int[][] arrays, int targetNumber) {
        boolean result = false;
        //先对二维数组进行非空判断，获取他们的行数和列数。
        if (arrays != null && arrays.length > 0) {
            int rowSize = arrays.length;
            int[] array = arrays[0];
            if (array != null && array.length > 0) {
                int columnSize = array.length;
                //开始查找
                int row = 0;
                int column = columnSize - 1;
                while (row < rowSize && column >= 0) {
                    if (arrays[row][column] == targetNumber) {
                        result = true;
                        break;
                    } else if (arrays[row][column] > targetNumber) {
                        --column;
                    } else {
                        ++row;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 生成一个二维数组，每一行都从左到右递增，每一列都从上到下递增。
     *
     * @param startNumber 左上角的数据
     * @param rowSize     行数
     * @param columnSize  列数
     * @param rowStep     行之间递增的step
     * @param columnStep  列之间递增的step
     * @return
     */
    private int[][] generateDoubleDimensionalArray(int startNumber, int rowSize, int columnSize,
                                                   int rowStep, int columnStep) {
        if (rowSize <= 0 || columnSize <= 0) {
            throw new RuntimeException("rowSize or columnSize cannot <= 0");
        }
        if (rowStep <= 0) {
            rowStep = 1;
        }
        int[][] arrays = new int[rowSize][columnSize];
        for (int m = 0; m < rowSize; m++) {
            for (int n = 0; n < columnSize; n++) {
                int value = startNumber + m * rowStep + n * columnStep;
                arrays[m][n] = value;
            }
        }
        return arrays;
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        int startNumber = 10;
        int rowSize = 5;
        int columnSize = 6;
        int rowStep = 2;
        int columnStep = 3;
        int[][] arrays = generateDoubleDimensionalArray(startNumber, rowSize, columnSize, rowStep, columnStep);

        StringBuffer sb = new StringBuffer();
        for (int m = 0; m < rowSize; m++) {
            for (int n = 0; n < columnSize; n++) {
                sb.append(String.valueOf(arrays[m][n])).append(",");
            }
            sb.append("\n");
        }
        LogUtils.e("二维数组为:" + sb.toString());

        int targetNumber = 26;
        boolean result = findFromBottomLeft(arrays, targetNumber);
        LogUtils.e(String.valueOf(targetNumber) + "的查询结果为:" + result);
    }

    /**
     * 从左下角查找
     *
     * @param arrays       二维有序数组
     * @param targetNumber 待查找的数字
     * @return
     */
    private boolean findFromBottomLeft(int[][] arrays, int targetNumber) {
        boolean result = false;
        //先对二维数组进行非空判断，获取他们的行数和列数。
        if (arrays != null && arrays.length > 0) {
            int rowSize = arrays.length;
            int[] array = arrays[0];
            if (array != null && array.length > 0) {
                int columnSize = array.length;
                //开始查找
                int row = rowSize - 1;
                int column = 0;
                while (row >=0 && column < columnSize) {
                    if (arrays[row][column] == targetNumber) {
                        result = true;
                        break;
                    } else if (arrays[row][column] > targetNumber) {
                        --row;
                    } else {
                        ++column;
                    }
                }
            }
        }
        return result;
    }
}
