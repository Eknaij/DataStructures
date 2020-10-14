package com.eknaij.binarysorttree;

import com.eknaij.tree.BinaryTree;

/**
 * @Author Eknaij
 * @Date 2020/10/14 14:12
 * @Description 测试类
 */
public class BstTest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        //构建一个二叉排序树
        BinarySortTree bst = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            bst.add(new BstNode(arr[i]));
        }
        //遍历BST查看结果
        bst.infixOrder();
//        bst.delete(5);//删除叶子节点
//        System.out.println("删除叶子节点后");
//        bst.infixOrder();

//        bst.delete(1);//删除叶子节点
//        System.out.println("删除有一个子节点的根节点后");
//        bst.infixOrder();

//        bst.delete(3);//删除叶子节点
//        System.out.println("删除有两个子节点的根节点后");
//        bst.infixOrder();

        bst.delete(2);
        bst.delete(5);
        bst.delete(9);
        bst.delete(12);
        bst.delete(7);
        bst.delete(3);
        bst.delete(10);
        bst.delete(1);


        System.out.println("删除全部节点后");
        bst.infixOrder();

    }
}
