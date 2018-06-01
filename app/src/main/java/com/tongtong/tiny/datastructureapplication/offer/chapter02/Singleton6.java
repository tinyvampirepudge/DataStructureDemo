package com.tongtong.tiny.datastructureapplication.offer.chapter02;

/**
 * Desc:    线程安全的
 *
 * @author tiny
 * @date 2018/6/2 上午12:00
 */
public class Singleton6 {
    private Singleton6() {
    }

    private static Singleton6 instance = null;

    public synchronized static Singleton6 getInstance() {
        if (instance == null) {
            instance = new Singleton6();
        }
        return instance;
    }
}
