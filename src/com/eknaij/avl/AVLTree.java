package com.eknaij.avl;


import com.eknaij.binarysorttree.BstNode;

/**
 * @Author Eknaij
 * @Date 2020/10/17 17:21
 * @Description 平衡二叉树
 */
public class AVLTree {
    private AVLNode root;


    public AVLNode getRoot() {
        return root;
    }

    //查找要删除的节点
    public AVLNode search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    //查找要删除的节点的父节点
    public AVLNode searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        //查找需要删除的节点
        AVLNode targetNode = search(value);
        if (targetNode == null) {
            //说明没有找到需要删除的节点
            System.out.println("需要删除的节点不存在！");
            return;
        }
        //如果当前当前BST中只有一个节点
        if (root.left == null && root.right == null) {
            root = null;//置成空树
        }
        //查找需要删除节点的父节点
        AVLNode targetParent = searchParent(value);
        if (targetNode.left == null && targetNode.right == null) {  //（1）如果要删除的节点是叶子节点
            if (targetParent != null) {
                //判断需要删除的节点在父节点的左子树还是右子树
                if (targetParent.left != null && targetParent.left.value == targetNode.value) { //在左子树
                    targetParent.left = null;
                }
                if (targetParent.right != null && targetParent.right.value == targetNode.value) {//在右子树
                    targetParent.right = null;
                }
            } else {
                root = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {  //（2）删除有两个子节点的节点
            //调用方法得到targetNode节点的右子树的最小值
//            int minVal = delRightTreeMin(targetNode.right);
            //调用方法得到targetNode节点的左子树的最大值
            int minVal = delRightTreeMax(targetNode.left);
            targetNode.value = minVal;
        } else { //(3)删除的节点是有一个子节点的节点
            //如果要删除的节点有左节点
            if (targetNode.left != null) {
                //判断一下要删除的节点是在父节点左子树还是右子树
                if (targetParent != null) {
                    if (targetParent.left != null && targetParent.left.value == targetNode.value) { //在左子树
                        targetParent.left = targetNode.left;
                    } else if (targetParent.right != null && targetParent.right.value == targetNode.value) {//在右子树
                        targetParent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
                //要删除的点有右节点
            } else {
                if (targetParent != null) {
                    if (targetParent.left != null && targetParent.left.value == targetNode.value) { //在左子树
                        targetParent.left = targetNode.right;
                    } else if (targetParent.right != null && targetParent.right.value == targetNode.value) {//在右子树
                        targetParent.right = targetNode.right;
                    }
                } else {
                    root = targetNode.right;
                }
            }
        }
    }

    /**
     * @param node 传入右子节点
     * @return
     */
    public int delRightTreeMin(AVLNode node) {
        AVLNode target = node;
        //循环的查找左子节点， 就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时 target 就指向了最小结点
        //删除最小结点
        delete(target.value);
        return target.value;
    }

    /**
     * @param node 传入左子节点
     * @return
     */
    public int delRightTreeMax(AVLNode node) {
        AVLNode target = node;
        //循环的查找右子节点， 就会找到最大值
        while (target.right != null) {
            target = target.right;
        }
        //这时 target 就指向了最大结点
        //删除最大结点
        delete(target.value);
        return target.value;
    }

    //添加节点
    public void add(AVLNode node) {
        //根节点为null时，第一个节点为根节点
        if (root == null)
            root = node;
        else
            root.add(node);
    }

    //遍历BST
    public void infixOrder() {
        if (root == null) {
            System.out.println("BST为null无法遍历");
            return;
        }
        root.infixOrder();
    }
}
