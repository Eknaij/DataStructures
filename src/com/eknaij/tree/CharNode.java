package com.eknaij.tree;

import java.util.ArrayDeque;

/**
 * @Author Eknaij
 * @Date 2020/9/23 11:23
 * @Description 节点
 */
public class CharNode {
    private char charNode;
    private CharNode left;
    private CharNode right;


    //说明
    //1. 如果 leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果 rightType == 0 表示指向是右子树, 如果 1 表示指向后继结点
    private int leftType;
    private int rightType;

    //用于记录上一个节点，遍历后序线索化二叉树时用到
    private CharNode parent;

    public CharNode getParent() {
        return parent;
    }

    public void setParent(CharNode parent) {
        this.parent = parent;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public CharNode(char charNode) {
        this.charNode = charNode;
    }

    //先序遍历
    public void preOrder() {
        System.out.print(this.getCharNode() + " ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print(this.getCharNode() + " ");
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.print(this.getCharNode() + " ");
    }

    //层次遍历
    public void level() {
        ArrayDeque<CharNode> queue = new ArrayDeque<>(20);
        //首先将根节点加入栈中
        queue.add(this);
        //利用队列遍历二叉树
        while (!queue.isEmpty()) {
            CharNode node = queue.poll();
            System.out.print(node.getCharNode() + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //前序查找
    public CharNode preFindChar(char target) {
        System.out.println("前序遍历查找，当前节点：" + this.getCharNode());
        //说明当前节点就是，直接返回
        if (this.getCharNode() == target)
            return this;
        //用于记录结果
        CharNode res = null;

        if (this.left != null)
            //遍历左子树
            res = this.left.preFindChar(target);

        if (res != null)
            //说明在左子树找到了，直接返回
            return res;

        if (this.right != null)
            //遍历右子树
            res = this.right.preFindChar(target);
        //无论右子树有没有找到，都直接返回
        return res;
    }

    //中序查找
    public CharNode midFindChar(char target) {

        //用于记录结果
        CharNode res = null;

        if (this.left != null)
            //遍历左子树
            res = this.left.midFindChar(target);

        if (res != null)
            //说明在左子树找到了，直接返回
            return res;
        //说明当前节点就是，直接返回
        System.out.println("中序遍历查找，当前节点：" + this.getCharNode());
        if (this.getCharNode() == target)
            return this;

        if (this.right != null)
            //遍历右子树
            res = this.right.midFindChar(target);
        //无论右子树有没有找到，都直接返回
        return res;
    }

    //后序查找
    public CharNode postFindChar(char target) {

        //用于记录结果
        CharNode res = null;

        if (this.left != null) {
            //遍历左子树
            res = this.left.postFindChar(target);
        }

        if (res != null) {
            //说明在左子树找到了，直接返回
            return res;
        }


        if (this.right != null) {
            //遍历右子树
            res = this.right.postFindChar(target);
        }

        if (res != null) {
            //说明在右子树找到了，直接返回
            return res;
        }


        //说明当前节点就是，直接返回
        System.out.println("后序遍历查找，当前节点：" + this.getCharNode());
        if (this.getCharNode() == target)
            return this;
        return res;
    }

    @Override
    public String toString() {
        return "CharNode{" +
                "charNode=" + charNode +
                '}';
    }

    public void delNode(char delChar) {
        //删除时判断当前节点的子节点是否是需要删除的节点
        if (this.left != null && this.left.getCharNode() == delChar) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.getCharNode() == delChar) {
            this.right = null;
            return;
        }
        //如果子节点不是，则需要继续递归子节点，直到找到需要删除的节点
        if (this.left != null) {
            this.left.delNode(delChar);
        }
        if (this.right != null) {
            this.right.delNode(delChar);
        }
    }

    public char getCharNode() {
        return charNode;
    }

    public void setCharNode(char charNode) {
        this.charNode = charNode;
    }

    public CharNode getLeft() {
        return left;
    }

    public void setLeft(CharNode left) {
        this.left = left;
    }

    public CharNode getRight() {
        return right;
    }

    public void setRight(CharNode right) {
        this.right = right;
    }
}
