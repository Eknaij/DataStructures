package com.eknaij.linkedlist;

/**
 * @ClassName SingleLinkedList
 * @Description 带头结点的单链表
 * @Author Eknaij
 * @Date 2020/6/10 16:44
 */
public class SingleLinkedList {
    //固定的头结点
    private DemoNode head = new DemoNode(0);

    public void add(DemoNode node) {
        //保持头指针不变，因此用一个临时变量来指向当前头指针
        DemoNode temp = head;
        while (true) {
            //找到最后一个结点
            if (temp.next == null) {
                break;//退出循环
            }
            //移动到下一个
            temp = temp.next;
        }
        temp.next = node;
    }

    public void show() {
        //保持头指针不变，因此用一个临时变量来指向当前头指针
        DemoNode temp = head.next;
        //如果头节点的下一个没有数据，说明链表是空的
        if (temp == null) {
            System.out.println("链表中无数据。");
            return;
        }
        while (true) {
            //如果到了最后一个，就退出循环
            if (temp == null)
                break;
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
