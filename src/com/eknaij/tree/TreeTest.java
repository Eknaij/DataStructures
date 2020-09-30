package com.eknaij.tree;

/**
 * @Author Eknaij
 * @Date 2020/9/23 11:39
 * @Description TODO
 */
public class TreeTest {
    public static void main(String[] args) {
        //先创建一个二叉树
        BinaryTree tree = new BinaryTree();
        CharNode nodeA = new CharNode('A');
        CharNode nodeB = new CharNode('B');
        CharNode nodeC = new CharNode('C');
        CharNode nodeD = new CharNode('D');
        CharNode nodeE = new CharNode('E');
        CharNode nodeF = new CharNode('F');
        CharNode nodeG = new CharNode('G');
        CharNode nodeH = new CharNode('H');
        CharNode nodeI = new CharNode('I');
        CharNode nodeJ = new CharNode('J');
        CharNode nodeK = new CharNode('K');
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);
        nodeD.setRight(nodeH);
        nodeE.setRight(nodeI);
        nodeC.setRight(nodeG);
        nodeC.setLeft(nodeF);
        nodeF.setLeft(nodeJ);
        nodeF.setRight(nodeK);
        tree.setRoot(nodeA);
//        System.out.println("先序遍历");
//        tree.pre();
//        System.out.println();
//        System.out.println("中序遍历");
//        tree.mid();
//        System.out.println();
//        System.out.println("后序遍历");
//        tree.post();
//        System.out.println("层次遍历");
//        tree.level();


//        System.out.println("先序遍历查找结果："+tree.preFind('K'));
//        System.out.println("中序遍历查找结果："+tree.midFind('K'));
//        System.out.println("后序遍历查找结果："+tree.postFind('K'));


        //测试删除
        tree.delNode('B');
        System.out.println("删除后进行一次先序遍历");
        tree.pre();


    }
}
