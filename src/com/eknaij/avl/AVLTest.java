package com.eknaij.avl;

/**
 * @Author Eknaij
 * @Date 2020/10/17 17:45
 * @Description TODO
 */
public class AVLTest {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};    //用于左旋
//        int[] arr = {10, 12, 8, 9, 7, 6};    //用于右旋
        int[] arr = {10, 11, 7, 6, 8, 9};    //用于测试双旋
        //创建一个AVL树
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLNode(arr[i]));
        }
        System.out.println("平衡后的树：");
        avlTree.infixOrder();
        System.out.println("树的根节点：" + avlTree.getRoot());
        System.out.println("树的左子节点：" + avlTree.getRoot().left);
        System.out.println("树的右子节点：" + avlTree.getRoot().right);
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("树的左子树高度：" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度：" + avlTree.getRoot().rightHeight());

    }
}
