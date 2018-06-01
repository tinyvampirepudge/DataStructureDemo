package com.tongtong.tiny.datastructureapplication.offer.chapter02;

/**
 * Desc:    强烈推荐的解法二：实现按需创建实例
 *
 * @author tiny
 * @date 2018/6/1 下午11:53
 */
public class Singleton5 {
    private Singleton5() {
    }

    private static class Holder {
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Holder.instance;
    }
}
