package com.eknaij.tree;

/**
 * @Author Eknaij
 * @Date 2020/9/22 9:14
 * @Description TODO
 */
public class BinaryTree {
    private CharNode root;

    //为了实现线索化， 需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时， pre 总是保留前一个结点
    private CharNode pre = null;

    public CharNode getPre() {
        return pre;
    }

    //中序线索化二叉树
    public void threadedNodes(CharNode node) {
        //如果 node==null, 不能线索化
        if (node == null) {
            return;
        }

        //(一)先线索化左子树
        threadedNodes(node.getLeft());
        //(二)线索化当前结点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

//        if (node.getRight() != null) {
//            node.setRight(...);
//            node.setRightType(1);
//        }
        //由于不知道当前节点的后继节点是哪一个，但是之前记录了前一个节点的信息，因此下一次递归后，再利用pre节点来对本次的右指针设置后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        //每处理一个结点后， 让当前结点是下一个结点的前驱结点
        pre = node;

        //(三)线索化右子树
        threadedNodes(node.getRight());
    }

    //中序线索化遍历
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        CharNode node = root;
        while (node != null) {
            //循环的找到leftType == 1的结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();
        }
    }

    //前序线索化二叉树
    public void preThreadedNodes(CharNode node) {
        //如果 node==null, 不能线索化
        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        pre = node;
        //(二)先线索化左子树
        if (node.getLeftType() != 1) {
            preThreadedNodes(node.getLeft());
        }
        //(三)再线索化右子树
        if (node.getRightType() != 1) {
            preThreadedNodes(node.getRight());
        }
    }

    //前序线索化遍历
    public void threadedListPre() {
        //定义一个变量，存储当前遍历的结点，从root开始
        CharNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                //如果是叶子节点，非前驱节点，打印当前这个结点
                System.out.print(node + ",");
                node = node.getLeft();
            }
            System.out.print(node + ",");
            //替换这个遍历的结点
            node = node.getRight();
        }
    }

    //后序线索化二叉树
    public void postThreadedNodes(CharNode node) {
        //如果 node==null, 不能线索化
        if (node == null) {
            return;
        }

        //(一)先线索化左子树
        postThreadedNodes(node.getLeft());
        //(二)再线索化右子树
        postThreadedNodes(node.getRight());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        pre = node;
    }

    //后序线索化遍历
    public void threadedListPost() {
        //1、找后序遍历方式开始的节点
        CharNode node = root;
        while (node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }
        while (node != null) {
            //右节点是线索
            if (node.getRightType() == 1) {
                System.out.print(node + ", ");
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.print(node + ", ");
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }

    public void setPre(CharNode pre) {
        this.pre = pre;
    }

    //前序遍历
    public void pre() {
        if (this.root != null)
            this.root.preOrder();
        else
            System.out.println("二叉树为空， 无法遍历");
    }

    //中序遍历
    public void mid() {
        if (this.root != null)
            this.root.infixOrder();
        else
            System.out.println("二叉树为空， 无法遍历");
    }

    //后序遍历
    public void post() {
        if (this.root != null)
            this.root.postOrder();
        else
            System.out.println("二叉树为空， 无法遍历");
    }

    public void level() {
        if (this.root != null)
            this.root.level();
        else
            System.out.println("二叉树为空， 无法进行层次遍历");
    }

    //先序遍历查找
    public CharNode preFind(char target) {
        if (root != null)
            return this.root.preFindChar(target);
        return null;
    }

    //中序遍历查找
    public CharNode midFind(char target) {
        if (root != null)
            return this.root.midFindChar(target);
        return null;
    }

    //后序遍历查找
    public CharNode postFind(char target) {
        if (root != null)
            return this.root.postFindChar(target);
        return null;
    }

    public void delNode(char delChar) {
        if (root != null) {
            //先判断当前节点是不是需要进行删除的节点，如果是直接置成空树
            if (root.getCharNode() == delChar) {
                root = null;
            } else {
                root.delNode(delChar);
            }
        } else {
            System.out.println("空树 无法删除");
        }
    }

    public CharNode getRoot() {
        return root;
    }

    public void setRoot(CharNode root) {
        this.root = root;
    }
}
