package com.eknaij.recursion;

/**
 * @ClassName Queue8
 * @Description 八皇后问题
 * @Author Eknaij
 * @Date 2020/7/25 15:39
 */
public class Queue8 {
    //定义皇后的最大数量有几个
    int max = 8;
    //用一个数组模拟棋盘，保存皇后放置位置的结果,比如 array = {0 , 4, 7, 5, 2, 6, 1, 3}，array[0]表示第一个皇后放在第一行第一列的位置，array[1]表示第二个皇后放在第二行第五列的位置
    int[] array = new int[max];
    //统计解的个数
    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解的个数为："+count);
        System.out.println("判断冲突的次数为："+judgeCount);
    }

    /**
     * 放置皇后的函数
     *
     * @param n 放置第几个皇后
     */
    public void check(int n) {
        //如果等于8，说明放置到了第九个皇后，因为从零开始，所以结束回溯
        if (n == 8) {
            print();    //打印
            return;
        }
        //开始放置皇后，皇后最大数为max
        for (int i = 0; i < max; i++) {
            //先把当前的皇后放置在第n+1行的i+1列的位置
            array[n] = i;
            //然后开始判断当前放置的皇后是否跟之前放置的皇后位置冲突
            if (judge(n)) {
                //如果不冲突，继续放置下一个皇后
                check(n + 1);
            }
            //如果冲突了，进行回溯，放置皇后在当前行的下一列位置，也就是i++列
        }
    }

    /**
     * 判断当前的皇后跟之前皇后是否冲突的函数
     *
     * @param n 当前放置的皇后
     * @return 是否冲突
     */
    public boolean judge(int n) {
        //判断冲突的次数
        judgeCount++;
        //将当前的皇后逐个与之前已放置的皇后进行比较
        for (int i = 0; i < n; i++) {
            //1. array[i] == array[n] 表示判断 第 n 个皇后是否和前面的 n-1 个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第 n 个皇后是否和第 i 皇后是否在同一斜线,在同一斜线的行差与列差的绝对值是相等的，可以用斜率的思维
            // n = 1 放置第 2 列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要， n 每次都在递增
            if (array[n] == array[i] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int n=10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i+j);
            }
        }

    }
}
