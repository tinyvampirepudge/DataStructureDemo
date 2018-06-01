package com.tongtong.tiny.datastructureapplication.offer.chapter02;

/**
 * Desc: 可行的解法：加同步锁前后两次判断实例是否已存在
 *
 * @author tiny
 * @date 2018/6/1 下午11:38
 */
public class Singleton3 {
    private Singleton3() {
    }

    private static Singleton3 instance = null;

    /**
     * 典型的DCL机制，但是在Java中会有问题。并不是线程安全。
     *
     * @return
     */
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
