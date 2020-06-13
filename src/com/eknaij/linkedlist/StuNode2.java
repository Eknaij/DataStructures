package com.eknaij.linkedlist;

/**
 * @ClassName StuNode2
 * @Description TODO
 * @Author Eknaij
 * @Date 2020/6/13 14:10
 */
public class StuNode2 {
    public int no;
    public String name;
    public StuNode2 next;   //指向下一个节点
    public StuNode2 pre;    //指向前一个节点

    public StuNode2(int no,String name){
        this.no=no;
        this.name = name;
    }
    @Override
    public String toString() {
        return "StuNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
