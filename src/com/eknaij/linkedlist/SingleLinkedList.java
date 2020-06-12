package com.eknaij.linkedlist;

import java.util.Stack;

/**
 * @ClassName SingleLinkedList
 * @Description 带头结点的单链表
 * @Author Eknaij
 * @Date 2020/6/10 16:44
 */
public class SingleLinkedList {
    //固定的头结点
    private StuNode head = new StuNode(0, "");

    /**
     * 添加，直接在链表后面追加
     *
     * @param node
     */

    public void add(StuNode node) {
        //保持头指针不变，因此用一个临时变量来指向当前头指针
        StuNode temp = head;
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

    /**
     * 有序添加，且不重复
     *
     * @param node 需要添加的节点
     */
    public void addByOrder(StuNode node) {
        StuNode temp = head;
        boolean flag = false;
        while (true) {
            //链表中无数据
            if (temp.next == null) {
                break;
            } else if (temp.next.no > node.no) {//找到放入的位置
                break;
            } else if (temp.next.no == node.no) {//不重复插入
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("数据%d重复,不再重复插入\n", node.no);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 修改某个节点
     *
     * @param node 需要修改的节点
     */
    public void update(StuNode node) {
        StuNode temp = head;
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
    public void delete(StuNode node) {
        StuNode temp = head;
        if (temp.next == null) {
            System.out.println("链表中无数据，无法进行删除操作");
            return;
        }
        while (temp.next != null) {
            if (temp.next.no == node.no) {//找到了需要删除的节点
                temp.next = temp.next.next;//删除节点
                System.out.println("删除成功！");
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有找到需要删除的节点。");
    }

    /**
     * 获取链表的有效个数
     *
     * @param node 头结点
     * @return 有效个数
     */
    public int getLength(StuNode node) {
        if (node.next == null) {//表示链表中无数据
            return 0;
        }
        int length = 0;
        while (node.next != null) { //循环到最后一个结束循环
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 查询倒数第index个节点
     *
     * @param head  头结点
     * @param index 需要查询的倒数第index个
     * @return 倒数第index个节点
     */
    public StuNode getLastIndex(StuNode head, int index) {
        //先获取链表的总长度
        int length = getLength(head);
        //当链表长度为0或者index不合法时，无法继续进行查找，直接返回null
        if (head.next == null || index > length || index <= 0) {
            System.out.println("");
            return null;
        }
        //此时的node为第一个节点
        StuNode node = head.next;
        for (int i = 0; i < length - index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 将链表进行反转,头插入法
     *
     * @param head
     */
    public void reverse(StuNode head) {
        if (head.next == null)
            return;
        StuNode reverseHead = new StuNode(0, "");
        StuNode temp = head.next;
        StuNode next;
        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 链表进行逆序输出，不改变原链表结构
     *
     * @param head
     */
    public void reverseShow(StuNode head) {
        if (head.next == null) {
            System.out.println("链表为空，不进行反转");
        }
        //用栈来记录链表的节点
        Stack<StuNode> stack = new Stack<>();
        while (head.next != null) {
            stack.push(head.next);
            head.next = head.next.next;
        }
        //出栈
        while (stack.size() > 0)
            System.out.println(stack.pop());

    }

    /**
     * 合并两个有序链表，合并后依然有序
     * @param list1
     * @param list2
     * @return 合并后链表的头结点
     */
    public StuNode Merge(StuNode list1, StuNode list2) {
        if (list1.next == null)
            return list2;
        if (list2.next == null)
            return list1;
        if (list2.next == null && list1.next == null)
            return null;
        StuNode head = new StuNode(0, "");
        head.next = null;
        StuNode root = head;
        while (list1.next != null && list2.next != null) {
            if (list1.next.no < list2.next.no) {
                head.next = list1.next;
                head = list1.next;
                list1.next = list1.next.next;
            } else {
                head.next = list2.next;
                head = list2.next;
                list2.next = list2.next.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if (list1.next != null) {
            head.next = list1.next;
        }
        if (list2.next != null) {
            head.next = list2.next;
        }
        return root.next;
    }

    /**
     * 遍历整个链表
     */
    public void show() {
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

    public StuNode getHead() {
        return head;
    }
}
