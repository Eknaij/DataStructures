package com.eknaij.sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Description 希尔排序
 * @Author Eknaij
 * @Date 2020/7/29 14:49
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        shellSort2(arr);
    }

    public static void shellSort(int[] array) {
        if (array.length == 0 || array == null) {
            return;
        }
        int temp = 0;
        int count = 0;
        //gap为增量，初始增量为数组长度的一半，每次循环之后都是上一次增量的一半
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //开始遍历每一个组
            for (int i = gap; i < array.length; i++) {
                // 遍历各组中的元素，对元素进行直接插入排序
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序 " + (++count) + " 轮后=" + Arrays.toString(array));
        }

        /*

        //分解希尔排序过程
        //第一次排序，增量为array.length/2 = 5
        for (int i = 5; i < array.length; i++) {
            // 遍历各组中所有的元素
            for (int j = i - 5; j >= 0; j = j - 5) {
                if (array[j] > array[j + 5]) {
                    temp = array[j];
                    array[j] = array[j + 5];
                    array[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序 1 轮后=" + Arrays.toString(array));

        //第二次排序，增量为5/2 = 2
        for (int i = 2; i < array.length; i++) {
            // 遍历各组中所有的元素
            for (int j = i - 2; j >= 0; j = j - 2) {
                if (array[j] > array[j + 2]) {
                    temp = array[j];
                    array[j] = array[j + 2];
                    array[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序 2 轮后=" + Arrays.toString(array));

        //第二次排序，增量为2/2 = 1
        for (int i = 1; i < array.length; i++) {
            // 遍历各组中所有的元素
            for (int j = i - 1; j >= 0; j = j - 1) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序 3 轮后=" + Arrays.toString(array));
         */
    }


    //希尔排序，移位方式
    public static void shellSort2(int[] array) {
        if (array.length == 0 || array == null) {
            return;
        }
        int count = 0;
        //gap为增量，初始增量为数组长度的一半，每次循环之后都是上一次增量的一半
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //开始遍历每一个组
            for (int i = gap; i < array.length; i++) {
                //记录需要插入的值
                int insertVal = array[i];
                //记录分组的前一个位置
                int index = i - gap;
                //开始遍历分组的元素与分组的步长gap有关
                for (int j = index; j >= 0 && array[j] > insertVal; j -= gap) {
                    //当分组里的元素比需要插入的值大时，赋值，这时分组头尾的值是一样的
                    array[j + gap] = array[j];
                    //记录指针往前移一个步长
                    index -= gap;
                }
                array[index + gap] = insertVal;
            }
            System.out.println("希尔排序 " + (++count) + " 轮后=" + Arrays.toString(array));
        }
    }
}
