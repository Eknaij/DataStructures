package com.eknaij.recursion;


import java.util.Stack;

/**
 * @ClassName maze
 * @Description 递归算法结局迷宫问题
 * @Author Eknaij
 * @Date 2020/7/25 9:50
 */
public class Maze {

    //定义一个栈，储存走过的位置信息
    private static Stack<Dot> stack = new Stack();

    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        int[][] map = {                           //迷宫地图,1代表墙壁，0代表可以行走的地方，假设1是外墙，终点为（8,8）
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        //使用递归回溯，从(1,1)这个位置开始
        setWay(map, 1, 1);
        System.out.println("行走顺序");
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
        System.out.println();
        //输出新的地图,  并标识过的递归
        System.out.println("地图行走情况");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 迷宫地图
     * @param i、j 表示从地图的哪个开始走迷宫
     * @return 该点是否可以继续走
     * 当行走的位置到达终点（8,8）时，迷宫完成，要是走完可走位置，仍然不到终点，则无解
     * 行走策略，假设我们行走的策略是上->右->下->左，如果当前方向可以走就继续走，不能走则换个方向继续尝试，如果四个方向都失败，回溯上一个点继续执行策略
     * 假设0为为走过的通路，1为墙，2为已走过可行路，3位走过，但不可行
     */
    public static boolean setWay(int[][] map, int i, int j) {
        Dot dot = new Dot(i, j);
        //结束回溯的条件，判断当前是否到达终点
        if (map[8][8] == 2) {
            return true;
        }
        //如果这个点是未走过的点
        if (map[i][j] == 0) {
            //先假设当前位置是可行的
            map[i][j] = 2;
            if (setWay(map, i - 1, j)) {//往上走试试能不能走通
                stack.push(dot);//可以走，则入栈
                return true;
            } else if (setWay(map, i, j + 1)) { //上走不通，则往右走
                stack.push(dot);
                return true;
            } else if (setWay(map, i + 1, j)) { //右边走不通，往下走
                stack.push(dot);
                return true;
            } else if (setWay(map, i, j - 1)) {    //最后尝试往左走
                stack.push(dot);
                return true;
            } else {//都走不通，说明这个点是死路
                map[i][j] = 3;
                return false;
            }
        } else {//说明这个点走过了，不再执行策略
            return false;
        }
    }

    /**
     * 定义一个类，记录行走的点的信息
     */
    static class Dot {
        int i;
        int j;

        public Dot(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "（"+i+","+j+"）";
        }
    }
}
