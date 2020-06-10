package com.eknaij.linkedlist;

/**
 * @ClassName DemoNode
 * @Description TODO
 * @Author Eknaij
 * @Date 2020/6/10 16:43
 */
public class DemoNode {
    public int no;
    public DemoNode next;
    public DemoNode(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "DemoNode{" +
                "no=" + no +
                '}';
    }
}
