package com.eknaij.sort;

import java.util.Arrays;

/**
 * @ClassName RadisSort
 * @Description 基数排序
 * @Author Eknaij
 * @Date 2020/7/31 10:50
 */
public class RadisSort {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, 517, 135, 157, 32, 45, 4, 1};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr 需要排序的数组
     */
    public static void radixSort(int[] arr) {
        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定一个“桶”，存放不同的数字
        int[][] bucket = new int[10][arr.length];

        //用一个数组来记录每个桶实际存放了多少个元素，十个桶，因此空间是10，基数排序实际是用空间换时间
        int[] bucketElementCounts = new int[10];

        //对每一位（个、十、百、千等）都要进行一次排序，因此用循环做处理，循环次数与最大的位数有关
        //取个位数需要n % 10，取十位数 n / 10 % 10，取百位 n / 100 %10
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //对数组每个元素的单位（个、十、百、千等），都要进行一次遍历，看存放在哪个桶中
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[j] / n % 10;
                bucket[temp][bucketElementCounts[temp]] = arr[j];
                bucketElementCounts[temp]++;
            }
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                //判断桶里是否有元素
                if (bucketElementCounts[j] != 0) {
                    //循环该桶即第 j 个桶(即第 j 个一维数组), 放入
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        //取出元素放入到 arr
                        arr[index++] = bucket[j][k];
                    }
                }
                //当前处理完后，把桶的个数置为0（因为已经取出，并放到arr里）
                bucketElementCounts[j] = 0;
            }
            System.out.println("第 " + (i + 1) + " 轮， 处理 arr =" + Arrays.toString(arr));
        }

        //逐步分解基数排序过程
//        int[][] bucket = new int[10][arr.length];
//        int[] bucketElementCounts = new int[10];//用一个数组来记录每个桶包含的元素个数
//        for (int i = 0; i < arr.length; i++) {
//            int temp = arr[i] / 1 % 10;
//            bucket[temp][bucketElementCounts[temp]] = arr[i];
//            bucketElementCounts[temp]++;
//        }
//        int index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (bucketElementCounts[i] != 0) {
//                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
//                for (int j = 0; j < bucketElementCounts[i]; j++) {
//                    //取出元素放入到 arr
//                    arr[index++] = bucket[i][j];
//                }
//            }
//            bucketElementCounts[i] = 0;
//        }
//        System.out.println("第 1 轮， 对个位的排序处理 arr =" + Arrays.toString(arr));
//
//
//        for (int i = 0; i < arr.length; i++) {
//            int temp = arr[i] / 10 % 10;
//            bucket[temp][bucketElementCounts[temp]] = arr[i];
//            bucketElementCounts[temp]++;
//        }
//        index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (bucketElementCounts[i] != 0) {
//                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
//                for (int j = 0; j < bucketElementCounts[i]; j++) {
//                    //取出元素放入到 arr
//                    arr[index++] = bucket[i][j];
//                }
//            }
//            bucketElementCounts[i] = 0;
//        }
//        System.out.println("第 2 轮， 对十位的排序处理 arr =" + Arrays.toString(arr));
//
//        for (int i = 0; i < arr.length; i++) {
//            int temp = arr[i] / 100 % 10;
//            bucket[temp][bucketElementCounts[temp]] = arr[i];
//            bucketElementCounts[temp]++;
//        }
//        index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (bucketElementCounts[i] != 0) {
//                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
//                for (int j = 0; j < bucketElementCounts[i]; j++) {
//                    //取出元素放入到 arr
//                    arr[index++] = bucket[i][j];
//                }
//            }
//            bucketElementCounts[i] = 0;
//        }
//        System.out.println("第 3 轮， 对百位的排序处理 arr =" + Arrays.toString(arr));

    }


}
