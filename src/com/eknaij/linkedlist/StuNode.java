package com.eknaij.linkedlist;

/**
 * @ClassName DemoNode
 * @Description TODO
 * @Author Eknaij
 * @Date 2020/6/10 16:43
 */
public class StuNode {
    public int no;  //学号
    public String name; //姓名
    public StuNode next;    //用于指向下一节点的指针

    public StuNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StuNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
