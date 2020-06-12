package com.eknaij.linkedlist;

/**
 * @ClassName DemoNode
 * @Description TODO
 * @Author Eknaij
 * @Date 2020/6/10 16:43
 */
public class StuNode {
    public int no;
    public String name;
    public StuNode next;

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
