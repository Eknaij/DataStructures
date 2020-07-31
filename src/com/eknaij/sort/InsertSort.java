package com.eknaij.sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description 直接插入排序
 * @Author Eknaij
 * @Date 2020/7/28 17:13
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] insertSort(int[] array) {
        if (array.length == 0 || array == null) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            //比较无序列表的第一个元素与有序列表的第一个元素，如果无序列表的第一个元素比有序列表的最后一个元素大，说明不需要进行插入，有序列表直接后移（i++）即可
            if (array[i] < array[i - 1]) {
                int insertVal = array[i];//记录需要进行插入的值
                int index = i - 1;//指向insertVal前一个数的指针，插入的位置就是index+1
                //从i的位置向前遍历查找可以插入的位置
                for (int j = index; j >= 0 && array[j] > insertVal; j--) {
                    //将有序列表中比insertVal大的数往后移动
                    array[j + 1] = array[j];
                    //只要有一个满足条件，insertVal需要放的位置就往前移动一位，注意index代表的是insertVal前一个数的指针
                    index--;
                }
                //插入有序列表中
                array[index + 1] = insertVal;
            }
        }
        return array;
    }
}
