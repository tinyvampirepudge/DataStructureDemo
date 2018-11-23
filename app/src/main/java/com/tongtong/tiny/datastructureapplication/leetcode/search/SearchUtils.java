package com.tongtong.tiny.datastructureapplication.leetcode.search;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/23 10:21 PM
 * @Version TODO
 */
public class SearchUtils {

    public static int[] generateArrayWithStep(int size, int step) {
        int[] a = new int[size];
        for (int i = 0, j = 0; i < size; i++, j += step) {
            a[i] = j;
        }
        return a;
    }

    public static String getArrayToString(int[] a) {
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
}
