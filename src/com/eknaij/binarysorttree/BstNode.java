package com.eknaij.binarysorttree;

/**
 * @Author Eknaij
 * @Date 2020/10/14 13:57
 * @Description BST的节点
 */
public class BstNode {
    int value;
    BstNode left;
    BstNode right;

    public BstNode(int value) {
        this.value = value;
    }

    //添加节点
    public void add(BstNode node) {
        if (node == null)
            return;
        //传入的节点与当前子树根节点的大小关系判断
        if (node.value < this.value) {
            //左子节点为空
            if (this.left == null) {
                this.left = node;
            } else {
                //递归判断左子树
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //查找节点

    /**
     * @param value 需要查找的节点
     * @return
     */
    public BstNode search(int value) {
        //如果当前节点刚好是需要查找的节点，直接返回
        if (value == this.value) {
            return this;

        } else if (value < this.value) {
            if (this.left == null) {//如果左子树为null直接返回
                return null;
            }
            return this.left.search(value);//递归左子树
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }


    /**
     * 查找要删除节点的父节点
     *
     * @param value 要找到的节点的值
     * @return 返回需要删除节点的父节点
     */
    public BstNode searchParent(int value) {

        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {//当前节点的左节点或者右节点等于要找的节点时，说明当前节点就是要找的节点
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.searchParent(value);
        } else if (value >= this.value && this.right != null) {
            return this.right.searchParent(value);
        }
        return null;
    }

    @Override
    public String toString() {
        return "BstNode{" +
                "value=" + value +
                '}';
    }
}
