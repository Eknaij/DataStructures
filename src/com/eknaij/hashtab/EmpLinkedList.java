package com.eknaij.hashtab;

/**
 * @Author Eknaij
 * @Date 2020/9/21 15:06
 * @Description TODO
 */
public class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = emp;
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第 " + (no + 1) + " 条链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 条链表的信息为");
        Emp cur = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", cur.id, cur.name);
            if (cur.next == null)
                break;
            cur = cur.next;
        }
        System.out.println();
    }

    public void findById(int no) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Emp cur = head;
        while (true) {
            if (cur.id == no) {
                System.out.printf(" => id=%d name=%s\n", cur.id, cur.name);
            }
            if (cur.next == null)
                break;
            cur = cur.next;

        }
    }
}
