package com.eknaij.sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description 归并排序
 * @Author Eknaij
 * @Date 2020/7/30 14:41
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};
//        int arr[] = {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param array 排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(array, left, mid, temp);
            //向右递归进行分解
            mergeSort(array, mid + 1, right, temp);
            //合并
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * @param array 排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //(一)
        //先把左右两边(有序)的数据按照规则填充到 temp 数组
        //直到左右两边的有序序列， 有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素， 小于等于右边有序序列的当前元素
            //即将左边的当前元素， 填充到 temp 数组
            if (array[i] < array[j]) {
                temp[t] = array[i];
                t++;
                i++;

            } else {//反之,将右边有序序列的当前元素， 填充到 temp 数组
                temp[t] = array[j];
                t++;
                j++;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到 temp
        //左边的有序序列还有剩余的元素， 就全部填充到 temp
        while (i <= mid) {
            temp[t] = array[i];
            i++;
            t++;

        }
        //右边的有序序列还有剩余的元素， 就全部填充到 temp
        while (j <= right) {
            temp[t] = array[j];
            i++;
            j++;
        }

        //(三)
        //将 temp 数组的元素拷贝到 array
        t = 0;
        int tempLeft = left; //
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
