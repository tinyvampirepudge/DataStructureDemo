package com.tongtong.tiny.datastructureapplication.leetcode.tree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tongtong.tiny.datastructureapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 树
 * @Author wangjianzhou@qding.me
 * @Date 2018/12/19 9:25 PM
 * @Version
 */
public class BinaryTreeActivity extends AppCompatActivity {
    @BindView(R.id.btn_test1)
    Button btnTest1;
    @BindView(R.id.btn_test2)
    Button btnTest2;
    @BindView(R.id.btn_test3)
    Button btnTest3;
    @BindView(R.id.btn_test4)
    Button btnTest4;
    private BinarySearchTree bst;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, BinaryTreeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_tree);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test1)
    public void onBtnTest1Clicked() {
        bst = new BinarySearchTree();
        int rootData = 10;
        bst.insert(rootData);// 根节点
        for (int i = 0; i < rootData * 2; i++) {
            if (i != rootData) {
                bst.insert(i);
            }
        }
        System.out.println("二叉查找树-新增：" + bst);
    }

    @OnClick(R.id.btn_test2)
    public void onBtnTest2Clicked() {
        if (bst != null) {
            int target = 1;
            BinarySearchTree.Node result = bst.find(target);
            System.out.println("二叉查找树-查找 data：" + target + ",result:" + result);
        }
    }

    @OnClick(R.id.btn_test3)
    public void onBtnTest3Clicked() {
        if (bst != null) {
            int target = 10;
            bst.delete(target);
            System.out.println("二叉查找树-删除 result：" + bst.toString());
        }
    }

    @OnClick(R.id.btn_test4)
    public void onBtnTest4Clicked() {

    }
}
