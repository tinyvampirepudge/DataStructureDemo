package com.tongtong.tiny.datastructureapplication.leetcode.stack;

/**
 * @Description: 自定义栈需要实现的接口
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/29 10:59 AM
 * @Version TODO
 */
public interface StackInterface {
    //入栈，成功则返回true，失败返回false。
    Boolean push(String value);
    //出栈，成功则返回数据，失败则返回null。
    String pop();
}
