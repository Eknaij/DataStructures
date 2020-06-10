package com.eknaij.linkedlist;

/**
 * @ClassName LinkedListTest
 * @Description 测试主类
 * @Author Eknaij
 * @Date 2020/6/10 16:58
 */
public class LinkedListTest {
    public static void main(String[] args) {
        DemoNode demoNode1 = new DemoNode(1);
        DemoNode demoNode2 = new DemoNode(2);
        DemoNode demoNode3 = new DemoNode(3);
        DemoNode demoNode4 = new DemoNode(4);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(demoNode1);
        singleLinkedList.add(demoNode2);
        singleLinkedList.add(demoNode3);
        singleLinkedList.add(demoNode4);
        singleLinkedList.show();
    }
}
