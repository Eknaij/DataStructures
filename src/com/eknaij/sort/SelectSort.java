package com.eknaij.sort;

import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Description 直接选择排序
 * @Author Eknaij
 * @Date 2020/7/28 14:12
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //先找到一个数组中的最小值，然后在最小值的下标的后一个元素开始，找到一个比他小的，并进行交换
    public static int[] selectSort(int[] array) {
        if (array.length == 0 || array == null) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            //假设当前下标为i的值是最小值
            int minIndex = i;
            //从最小值的下一个开始找，看能否找到一个比他更小的
            for (int j = i + 1; j < array.length; j++) {
                //判断这个值是不是比最小值小
                if (array[j] < array[minIndex]) {
                    //当前值比预设定的最小值还要小,更改最小值的下标
                    minIndex = j;
                }
            }
            //交换两个值
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
