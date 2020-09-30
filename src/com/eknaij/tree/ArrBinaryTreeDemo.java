package com.eknaij.tree;

/**
 * @Author Eknaij
 * @Date 2020/9/28 8:55
 * @Description 顺序存储二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
        System.out.println();
        arrBinaryTree.midOrder(0);
        System.out.println();
        arrBinaryTree.postOrder(0);
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 先序遍历
     *
     * @param index 数组下标
     */
    public void preOrder(int index) {
        //如果数组为空， 或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空， 不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.print(arr[index] + "  ");
        //向左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void midOrder(int index) {
        //如果数组为空， 或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空， 不能按照二叉树的前序遍历");
        }
        //向左递归
        if ((index * 2 + 1) < arr.length) {
            midOrder(2 * index + 1);
        }
        //输出当前这个元素
        System.out.print(arr[index] + "  ");

        //向右递归
        if ((index * 2 + 2) < arr.length) {
            midOrder(2 * index + 2);
        }
    }


    public void postOrder(int index) {
        //如果数组为空， 或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空， 不能按照二叉树的前序遍历");
        }
        //向左递归
        if ((index * 2 + 1) < arr.length) {
            postOrder(2 * index + 1);
        }
        //向右递归
        if ((index * 2 + 2) < arr.length) {
            postOrder(2 * index + 2);
        }
        //输出当前这个元素
        System.out.print(arr[index] + "  ");
    }
}
