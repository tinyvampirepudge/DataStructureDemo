package com.tongtong.tiny.datastructureapplication.leetcode.search;

import com.tongtong.tiny.datastructureapplication.util.LogUtils;

import java.text.DecimalFormat;

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

    /**
     * 二分查找求解平方根。代码有问题。
     *
     * @param value
     * @param precision
     * @return
     */
    public static double sqrtByBinarySearch(double value, double precision, int digits) {
        if (value < 0 || Double.isNaN(value)) {
            return Double.NaN;
        }

        if (value == Double.POSITIVE_INFINITY) {
            return value;
        }

        if (value == 0.0 || value == -0.0) {
            return value;
        }

        double low = 0;
        double high = value;

        double mid = low + ((high - low) / 2);
        while (Math.abs(low - high) >= (precision)) {
            if (mid * mid > value) {
                high = mid;
            } else if (mid * mid < value) {
                low = mid;
            } else if (Math.abs(mid * mid - value) < precision) {
                return mid;
            }
            mid = low + ((high - low) / 2);
        }

        /**
         * 默认保留两位小数
         */
        if (digits < 0) {
            digits = 2;
        }
        if (digits > 0) {
            StringBuilder sb = new StringBuilder("#.");
            for (int i = 0; i < digits; i++) {
                sb.append("#");
            }
            DecimalFormat df = new DecimalFormat(sb.toString());
            mid = Double.valueOf(df.format(mid));
        }

        if (mid == (int) mid) {
            mid = (int) mid;
        }

        return mid;
    }

    /**
     * Returns the correctly rounded positive square root of a
     * {@code double} value.
     * Special cases:
     * <ul><li>If the argument is NaN or less than zero, then the result
     * is NaN.
     * <li>If the argument is positive infinity, then the result is positive
     * infinity.
     * <li>If the argument is positive zero or negative zero, then the
     * result is the same as the argument.</ul>
     * Otherwise, the result is the {@code double} value closest to
     * the true mathematical square root of the argument value.
     *
     * @param a a value.
     * @return the positive square root of {@code a}.
     */
    /*public static native double sqrtByBinarySearch(double a);*/

    /**
     * 牛顿迭代法求解平方根。
     * 极端值处理参考Math.sqrtByBinarySearch(double v)；
     *
     * @param value
     * @param precision 精确度。
     * @param digits    保留的小数点位数
     * @return
     */
    public static double sqrtByNewtonRaphson(double value, double precision, int digits) {
        if (value < 0 || Double.isNaN(value)) {
            return Double.NaN;
        }

        if (value == Double.POSITIVE_INFINITY) {
            return value;
        }

        if (value == 0.0 || value == -0.0) {
            return value;
        }

        double result = value;
        double last;
        do {
            last = result;
            result = (result + value / result) / 2;
        } while (Math.abs(result - last) > precision);

        /**
         * 默认保留两位小数
         */
        if (digits < 0) {
            digits = 2;
        }
        if (digits > 0) {
            StringBuilder sb = new StringBuilder("#.");
            for (int i = 0; i < digits; i++) {
                sb.append("#");
            }
            DecimalFormat df = new DecimalFormat(sb.toString());
            result = Double.valueOf(df.format(result));
        }

        if (result == (int) result) {
            result = (int) result;
        }

        return result;
    }

    /**
     * 查找第一个值等于给定值的元素
     * 存在重复值。
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchVarient1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchVarient2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchVarient3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchVarient4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if ((mid == n - 1) || (a[mid + 1] > value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
