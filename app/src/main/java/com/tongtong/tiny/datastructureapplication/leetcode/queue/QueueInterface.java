package com.tongtong.tiny.datastructureapplication.leetcode.queue;

/**
 * @Description: 自定义队列的接口
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 3:56 PM
 * @Version TODO
 */
public interface QueueInterface {
    /**
     * 入队
     *
     * @param value
     * @return
     */
    Boolean enqueue(String value);

    /**
     * 出队
     *
     * @return
     */
    String dequeue();
}
