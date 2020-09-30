package com.eknaij.tree;


/**
 * @Author Eknaij
 * @Date 2020/9/29 11:09
 * @Description TODO
 */
public class ThreadedTest {
    public static void main(String[] args) {
        //先创建一个二叉树
        BinaryTree tree = new BinaryTree();
        CharNode nodeA = new CharNode('A');
        CharNode nodeB = new CharNode('B');
        CharNode nodeC = new CharNode('C');
        CharNode nodeD = new CharNode('D');
        CharNode nodeE = new CharNode('E');
        CharNode nodeF = new CharNode('F');
        nodeA.setLeft(nodeB);
        nodeB.setLeft(nodeD);
        nodeA.setRight(nodeC);
        nodeC.setLeft(nodeE);
        nodeC.setRight(nodeF);
        tree.setRoot(nodeA);

        //中序线索化
//        tree.threadedNodes(nodeA);
        //前序线索化
//        tree.preThreadedNodes(nodeA);
        //后序线索化
        tree.postThreadedNodes(nodeA);


        CharNode leftNode = nodeA.getLeft();
        CharNode rightNode = nodeA.getRight();
        System.out.println(nodeA+"节点的前驱节点是："+leftNode);
        System.out.println(nodeA+"节点的后继节点是："+rightNode);


//        tree.threadedList();
//        tree.threadedListPre();
        tree.threadedListPost();

    }

}
