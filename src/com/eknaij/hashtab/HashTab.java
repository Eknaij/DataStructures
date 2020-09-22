package com.eknaij.hashtab;

/**
 * @Author Eknaij
 * @Date 2020/9/21 15:06
 * @Description TODO
 */
public class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size; //表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListNO = hashMethod(emp.id);
        empLinkedLists[empLinkedListNO].add(emp);
    }

    public int hashMethod(int no) {
        return no % size;
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public void findById(int id) {
        int empLinkedListNO = hashMethod(id);
        EmpLinkedList empLinkedList = empLinkedLists[empLinkedListNO];
        empLinkedList.findById(id);
    }

}
