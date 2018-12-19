package com.tongtong.tiny.datastructureapplication.leetcode.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: 哈希算法
 * @Author wangjianzhou@qding.me
 * @Date 2018/12/17 10:07 PM
 * @Version
 */
public class HashAlgorithmTest {
    public static void main(String[] args) {
        String src = "月落乌啼霜满天";
        String result = getMD5(src);
        System.out.println("result:" + result);

        System.out.println("result11:" + getMD5(" 今天我来讲哈希算法 "));
        System.out.println("result22:" + getMD5("jiajia"));
    }

    /**
     * MD5加密
     *
     * @param val
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(String val) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(val.getBytes());
            byte[] m = md5.digest();// 加密
            return getString(m);
        } catch (NoSuchAlgorithmException e) {
            return val;
        }

    }

    private static String getString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        return sb.toString();
    }
}
