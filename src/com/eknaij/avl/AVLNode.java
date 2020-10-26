package com.eknaij.avl;

/**
 * @Author Eknaij
 * @Date 2020/10/17 17:22
 * @Description 平衡二叉树节点
 */
public class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;

    //求左子树的高度
    public int leftHeight() {
        return left == null ? 0 : left.height();
    }

    //求右子树的高度
    public int rightHeight() {
        return right == null ? 0 : right.height();
    }

    //求出当前节点为根节点的树的高度
    public int height() {
        //依次递归找出树的高度
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


    //左旋转
    public void leftRotate() {
        //建立一个新节点，等于当前节点
        AVLNode newNode = new AVLNode(this.value);
        //让新节点的左子树等于当前节点的左子树
        newNode.left = this.left;
        //让新节点的右子树等于当前节点的右子树的左子树
        newNode.right = this.right.left;
        //当前节点的值等于当前节点的右子树的值
        this.value = this.right.value;
        //把当前节点的右子树指向它右子树的右子树
        this.right = this.right.right;
        //当前节点的左子树指向新的节点
        this.left = newNode;
    }

    //右旋转
    public void rightRotate() {
        //建立一个新节点，等于当前节点
        AVLNode newNode = new AVLNode(this.value);
        //新节点的右子树等于当前根节点的右子树
        newNode.right = this.right;
        //新节点的左子树等于当前根节点的左子树的右子树
        newNode.left = this.left.right;
        //令当前根节点的值等于其左子树的值
        this.value = this.left.value;
        //令当前根节点的左子树指向其左子树的左子树
        this.left = this.left.left;
        //令当前根节点的右子树指向新的节点
        this.right = newNode;
    }

    public AVLNode(int value) {
        this.value = value;
    }

    //添加节点
    public void add(AVLNode node) {
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
        //每次添加一个节点后，如果右子树的高度比左子树的高度大于1，就左旋
        if (rightHeight() - leftHeight() > 1) {
            //当前树的右子树不为空，并且当前树右子树的
            if (this.right != null && this.right.rightHeight() < this.right.leftHeight()) {
                this.right.rightRotate();
            }
            this.leftRotate();//左旋
            return;
        }
        if (leftHeight() - rightHeight() > 1) {//说明当前这颗树需要进行右旋转
            if (this.left != null && this.left.leftHeight() < this.left.rightHeight()) {
                this.left.leftRotate();
            }
            this.rightRotate();//右旋
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
    public AVLNode search(int value) {
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
    public AVLNode searchParent(int value) {

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
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}
