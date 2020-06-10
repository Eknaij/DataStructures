package com.eknaij.queue;

/**
 * @Description 环形队列
 * @Author Hjianke
 * @Date 2020/4/21 14:00
 */
public class CircleArray {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头，初始值0，指向第一个元素
    private int rear; // 队列尾，初始值0，指向最后一个元素的下一个位置
    private int[] arr; // 该数据用于存放数据, 模拟队列

    // 创建队列的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return front == (rear + 1) % maxSize;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队满，不可入队");
            return;
        }
        arr[rear] = n;
        //当rear指针在数组末端时，如果不取模数组会越界，因此要进行取模运算
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据, 出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队空，不可出队");
        }
        int value = arr[front];
        //front有可能移动到数组末端，因此考虑取模
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队空,无数据");
            return;
        }
        //从front开始遍历，直到rear指针结束
        for (int i = front; i < front + (rear + maxSize - front) % maxSize; i++)
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);//由于是环形，由于i=front开始，有可能在数组末端，因此i需要进行取模
    }

    //数组有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队空,无数据");
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return arr[(rear - 1 + maxSize) % maxSize];
    }
}
