package com.eknaij.linkedlist;

/**
 * @ClassName Josepfu
 * @Description 约瑟夫环问题
 * @Author Eknaij
 * @Date 2020/6/13 15:19
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkekList circleSingleLinkekList = new CircleSingleLinkekList();
        circleSingleLinkekList.addNode(5);
        circleSingleLinkekList.showNode();
        circleSingleLinkekList.out(1, 2, 5);

    }
}

//创建一个环形链表
class CircleSingleLinkekList {
    //创建first节点，当前没有编号
    private Node first = null;

    //添加小孩，构建一个环形链表
    public void addNode(int nums) {
        if (nums < 1) {
            System.out.println("nums error");
            return;
        }
        Node cur = null;//用于指向最后一个节点
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.setNext(first);//构建环形，由于只有一个节点，因此是自己指向自己
                cur = first;//因为first不能动，因此用一个指针来指向first
            } else {
                cur.setNext(node);
                node.setNext(first);
                cur = node;
            }
        }
    }

    public void showNode() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Node curNode = first;
        while (true) {
            System.out.println("NO:" + curNode.getNo());
            if (curNode.getNext() == first) break;
            curNode = curNode.getNext();
        }

    }

    /**
     * @param k 从第几个开始数
     * @param m 每次数几个
     * @param n 一开始的总数目
     */
    public void out(int k, int m, int n) {
        if (first == null || k < 1 || k > n) {
            System.out.println("参数不合法，请重新输入。");
        }
        Node cur = first;
        //将cur移动到first节点的前一个节点
        while (true) {
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
        //开始前两个指针先移动到k-1处,因为从k出开始报数
        for (int i = 0; i < k - 1; i++) {
            first = first.getNext();
            cur = cur.getNext();
        }
        while (true) {
            if (cur == first)//只剩一个
                break;
            //first和cur同时移动m-1次，模拟报数过程，循环结束报数完毕，first就是要出队的编号
            for (int i = 0; i < m - 1; i++) {
                first = first.getNext();
                cur = cur.getNext();
            }
            System.out.println("移除节点：" + first.getNo());//模拟出队
            first = first.getNext();    //移动到下一个人，继续报数
            cur.setNext(first); //cur指针始终紧邻first
        }
        System.out.println("最后的节点为：" + first.getNo());
    }
}

//创建一个Boy类，表示一个节点
class Node {
    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}