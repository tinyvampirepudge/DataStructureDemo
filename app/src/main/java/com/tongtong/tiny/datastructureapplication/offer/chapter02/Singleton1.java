package com.tongtong.tiny.datastructureapplication.offer.chapter02;

/**
 * Desc: 不好的解法一，只适用于单线程环境。
 *
 * @author tiny
 * @date 2018/6/1 下午11:34
 */
public class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
