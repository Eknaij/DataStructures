package com.eknaij.stack;

import com.eknaij.linkedlist.StuNode;

import java.util.Scanner;

/**
 * @ClassName StackTest
 * @Description 链栈、顺序栈测试类
 * @Author Eknaij
 * @Date 2020/7/21 9:28
 */
public class StackTest {
    public static void main(String[] args) {
        //测试一下 ArrayStack 是否正确
        //先创建一个 ArrayStack 对象->表示栈
//      ArrayStack stack = new ArrayStack(4);
        //测试链栈
        LinkStack stack = new LinkStack();
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    StuNode node = new StuNode(value,value+"");
                    stack.push(node);
                    break;
                case "pop":
                    try {
//                        int res = stack.pop();
//                        System.out.printf("出栈的数据是 %d\n", res);
                        System.out.println(stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }
}
