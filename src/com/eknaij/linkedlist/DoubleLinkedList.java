package com.eknaij.linkedlist;

/**
 * @ClassName DoubleLinkedList
 * @Description 双向链表
 * @Author Eknaij
 * @Date 2020/6/13 14:08
 */
public class DoubleLinkedList {
    private StuNode2 head = new StuNode2(0, "");

    public StuNode2 getHead() {
        return head;
    }


    public void add(StuNode2 node) {
        //保持头指针不变，因此用一个临时变量来指向当前头指针
        StuNode2 temp = head;
        while (true) {
            //找到最后一个结点
            if (temp.next == null) {
                break;//退出循环
            }
            //移动到下一个
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;//将新节点的pre指针指向前一个节点
    }

    /**
     * 修改某个节点
     *
     * @param node 需要修改的节点
     */
    public void update(StuNode2 node) {
        StuNode2 temp = head;
        if (temp.next == null) {
            System.out.println("链表中无数据，无法进行修改操作");
            return;
        }
        while (true) {
            if (temp.next == null) {
                System.out.println("找不到相关相关no，无法进行修改");
                return;
            } else if (temp.next.no == node.no) {//找到了相关的数据
                temp.next.name = node.name;//修改
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除某个节点
     *
     * @param node 需要删除的节点
     */
    public void delete(StuNode2 node) {
        StuNode2 temp = head;
        if (temp.next == null) {
            System.out.println("链表中无数据，无法进行删除操作");
            return;
        }
        while (temp != null) {
            //带头节点的双向链表只需要找到那个需要删除的数据
            //删除逻辑，假设A、B、C需要B，将B的前一个节点(B.pre)的下一个节点(B.pre.next)指向C(B.next),
            //将C的前一个节点(C.pre,也就是B.next.pre)指向B的前一个节点(B.pre),至此B的前后节点都已断开
            if (temp.no == node.no) {//找到了需要删除的节点
                temp.pre.next = temp.next;
                if (temp.next !=null)   //要删除的节点不是最后一个节点
                    temp.next.pre = temp.pre;
                System.out.println("删除成功！");
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有找到需要删除的节点。");
    }


    /**
     * 遍历整个链表
     */
    public void show() {
        //保持头指针不变，因此用一个临时变量来指向当前头指针
        StuNode2 temp = head.next;
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
