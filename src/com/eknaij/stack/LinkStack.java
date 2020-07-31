package com.eknaij.stack;

import com.eknaij.linkedlist.StuNode;

/**
 * @ClassName LinkStacj
 * @Description 链栈
 * @Author Eknaij
 * @Date 2020/7/21 9:37
 */
public class LinkStack {
    private StuNode head = new StuNode(0, "");


    //判断是否栈空
    public boolean isEmpty() {
        return head.next == null;
    }

    //入栈
    public void push(StuNode node) {
        node.next = head.next;
        head.next = node;
    }

    //出栈
    public StuNode pop() {
        if (isEmpty()) {
            throw new RuntimeException("链栈无数据");
        }
        StuNode node = head.next;
        head.next = node.next;
        node.next = null;
        return node;
    }

    //遍历链栈
    public void list() {
        //保持头指针不变，因此用一个临时变量来指向当前头指针
        StuNode temp = head.next;
        //如果头节点的下一个没有数据，说明链表是空的
        if (temp == null) {
            System.out.println("链表中无数据。");
            return;
        }
        while (temp != null) {
            //如果到了最后一个，就退出循环
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
