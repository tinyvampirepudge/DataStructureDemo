package com.tongtong.tiny.datastructureapplication.leetcode.tree;

import org.w3c.dom.Node;

/**
 * @Description: 二叉查找树，不支持重复数据。
 * @Author wangjianzhou@qding.me
 * @Date 2018/12/19 9:24 PM
 * @Version
 */
public class BinarySearchTree {
    private Node root;// 根节点

    /**
     * 插入数据
     *
     * @param data
     */
    public void insert(int data) {
        // 如果根节点没有数据，就将数据添加给根节点
        if (root == null) {
            root = new Node(data);
            return;
        }

        Node p = root;
        while (p != null) {
            if (data > p.data) {
                // 如果右子树为空，则根据当前数据新增右子树
                if (null == p.right) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {// data < p.data
                if (null == p.left) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 查找方法
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = root;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 删除
     *
     * @param data
     */
    public void delete(int data) {
        Node p = root;// p结点指向要删除的结点，初始化指向根节点
        Node pp = null;// pp记录的是p的父节点。

        //查找要删除的结点。
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        // 如果为空，
        if (null == p) {
            return;
        }

        // 要删除的结点有两个子节点
        if (p.left != null && p.right != null) {// 查找
            Node minP = p.right;
            Node minPP = p;// minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;// 将 minP 的数据替换到p中
            // 给 p 和 pp 重新赋值
            p = minP;
            pp = minPP;
        }

        // 删除结点是叶子节点或者仅有一个子节点
        Node child;// p的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        // 删除结点
        if (pp == null) {        // 删除的是根节点
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    /**
     * 定义Node
     */
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
