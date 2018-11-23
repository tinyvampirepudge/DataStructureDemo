package com.tongtong.tiny.datastructureapplication.leetcode.search;

/**
 * @Description: 二分查找
 * @Author wangjianzhou@qding.me
 * @Date 2018/11/23 10:12 PM
 * @Version
 */
public class BinarySearch {

    /**
     * 二分查找，针对不存在重复元素的。非递归实现。
     *
     * @param a     升序数组
     * @param n     数组大小
     * @param value 要查找的数值
     * @return 返回值表示要查找的数据在数组中的角标，如果没有则返回-1.
     */
    public static int binarySearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找，针对不存在重复元素的。递归实现。
     *
     * @param a     升序数组
     * @param n     数组大小
     * @param value 要查找的数值
     * @return 返回值表示要查找的数据在数组中的角标，如果没有则返回-1.
     */
    public static int binarySearch2(int[] a, int n, int value) {
        return binarySearchInternally(a, 0, n - 1, value);
    }

    private static int binarySearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return binarySearchInternally(a, mid + 1, high, value);
        } else {
            return binarySearchInternally(a, low, mid - 1, value);
        }
    }
}