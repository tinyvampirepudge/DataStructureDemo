package com.tongtong.tiny.datastructureapplication.offer.chapter02;

/**
 * Desc:    强烈推荐的解法一：利用静态构造函数
 *
 * @author tiny
 * @date 2018/6/1 下午11:52
 */
public class Singleton4 {
    private Singleton4() {
    }

    private static Singleton4 singleton = new Singleton4();

    public static Singleton4 getSingleton() {
        return singleton;
    }
}
