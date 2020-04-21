package com.eknaij.sparsearray;

/**
 * @Description 稀疏数组
 * @Author Eknaij
 * @Date 2020/4/21 9:11
 */
public class SparseArray {
    public static void main(String[] args) {
        int size = 6;
        // 创建一个原始的二维数组
        int initArr1[][] = new int[size][size];
        initArr1[1][2] = 1;
        initArr1[2][3] = 2;
        initArr1[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始二维数组:");
        for (int[] row : initArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组的思想
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (initArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = size;
        sparseArr[0][1] = size;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到 sparseArr中
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (initArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = initArr1[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println();
        System.out.println("得到稀疏数组为:");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组 --> 恢复成 原始的二维数组
		//1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int initArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组
        for (int i = 1; i < sparseArr.length; i++)
            initArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : initArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
