package com.tongtong.tiny.datastructureapplication.offer.chapter02;

/**
 * Desc: 不好的解法二：虽然在多线程环境中能工作但效率不高.
 *
 * @author tiny
 * @date 2018/6/1 下午11:36
 */
public class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        synchronized (Singleton2.class) {
            if (instance == null) {
                instance = new Singleton2();
            }
        }
        return instance;
    }
}
