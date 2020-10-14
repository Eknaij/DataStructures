package com.eknaij.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Eknaij
 * @Date 2020/10/9 9:32
 * @Description 哈弗曼树的构建
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {135, 5, 87, 517, 135, 157, 32, 45, 4, 1};

        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            //利用Collections的sort方法进行排序，list里的对象必须实现Comparable接口
            Collections.sort(nodes);
            //取出最小的一个元素
            Node left = nodes.get(0);
            //取出第二小的元素
            Node right = nodes.get(1);
            //将最小的两个元素 构建成一个新的子树
            Node parent = new Node(left.val + right.val);
            parent.left = left;
            parent.right = right;
            nodes.add(parent);
            //移除两个已经使用的最小元素
            nodes.remove(left);
            nodes.remove(right);
        }
        return nodes.get(0);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树， 不能遍历~~");
        }
    }
}

class Node implements Comparable<Node> {
    int val;
    Node left;
    Node right;

    public Node(int value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (
                this.right != null) {
            this.right.preOrder();
        }
    }
}

