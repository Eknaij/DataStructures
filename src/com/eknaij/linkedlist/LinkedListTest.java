package com.eknaij.linkedlist;

/**
 * @ClassName LinkedListTest
 * @Description 测试主类
 * @Author Eknaij
 * @Date 2020/6/10 16:58
 */
public class LinkedListTest {
    public static void main(String[] args) {
        StuNode demoNode1 = new StuNode(1, "小明");
        StuNode demoNode2 = new StuNode(2, "小华");
        StuNode demoNode3 = new StuNode(3, "小红");
        StuNode demoNode4 = new StuNode(4, "小王");
        StuNode demoNode5 = new StuNode(4, "小黄~~~");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(demoNode1);
//        singleLinkedList.add(demoNode2);
//        singleLinkedList.add(demoNode3);
//        singleLinkedList.add(demoNode4);

        singleLinkedList.addByOrder(demoNode1);
        singleLinkedList.addByOrder(demoNode3);
        singleLinkedList.addByOrder(demoNode2);
        singleLinkedList.addByOrder(demoNode4);
//        singleLinkedList.show();
        singleLinkedList.update(demoNode5);
//        singleLinkedList.show();
//        singleLinkedList.addByOrder(demoNode5);


        singleLinkedList.delete(demoNode5);
        singleLinkedList.show();
//        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
//        System.out.println(singleLinkedList.getLastIndex(singleLinkedList.getHead(),1));
        singleLinkedList.reverse(singleLinkedList.getHead());
        System.out.println("反转后");
        singleLinkedList.show();
        System.out.println("逆序打印");
        singleLinkedList.reverseShow(singleLinkedList.getHead());


        System.out.println("合并两个链表");

        SingleLinkedList testMeger1 = new SingleLinkedList();
        testMeger1.addByOrder(demoNode1);
        testMeger1.addByOrder(demoNode3);
        testMeger1.addByOrder(demoNode2);
        testMeger1.addByOrder(demoNode4);

        SingleLinkedList testMeger2 = new SingleLinkedList();
        StuNode demoNode11 = new StuNode(4, "小张");
        StuNode demoNode21 = new StuNode(5, "小李");
        StuNode demoNode31 = new StuNode(6, "小丽");
        StuNode demoNode41 = new StuNode(7, "小小");

        testMeger2.addByOrder(demoNode11);
        testMeger2.addByOrder(demoNode31);
        testMeger2.addByOrder(demoNode21);
        testMeger2.addByOrder(demoNode41);

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(singleLinkedList.Merge(testMeger1.getHead(),testMeger2.getHead()));
        singleLinkedList2.show();

    }
}
