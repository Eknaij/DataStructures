package com.eknaij.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 快速排序
 * @Author Eknaij
 * @Date 2020/7/30 9:44
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};
//        int arr[] = {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] array, int low, int high) {
        //左指针
        int left = low;
        //右指针
        int right = high;
        //分割左右的目标值，默认开始为第一个
        int pivot = array[low];
        //当左指针没有超过右指针的时候，说明还没有结束
        int temp = 0;
        while (left < right) {
            //先从右边指针right，找到一个比pivot小的记录，然后进行交换，如果找到的记录比pivot大，指针左移
            while (left < right && array[right] >= pivot) {
                right--;
            }
            //如果数组有大量相同的元素，比如{1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1}，指针会一直移动，会抛出栈溢出异常，因此只有当left < right成立的条件下，才进行交换，下同
            if (left < right) {
                //将比pivot小的值，换到pivot左边
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;//由于交换了一次，说明这个数已经与pivot比较完毕（比pivot小），下次循环可以直接跳过这个数，当然不跳过也行，不影响结果，但影响效率
            }
            //再从左边left指针，找到一个比pivot大的记录，然后进行交换
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                //将比pivot大的值，换到pivot右边
                temp = array[right];
                array[right] = array[left];
                array[left] = temp;
                right--;//由于交换了一次，说明这个数已经与pivot比较完毕（比pivot大），下次循环可以直接跳过这个数，当然不跳过也行，不影响结果
            }
        }
        System.out.println("一轮后："+Arrays.toString(array));
        //如果left>low,说明最起码找到了一个比pivot小的记录，pivot左边还有起码大于等于一个值需要进行比较，将左边的再进行一轮快速排序
        if (left > low) {
            quickSort(array, low, left - 1);
        }
        //如果right<high,说明最起码找到了一个比pivot大的记录，pivot右边还有起码大于等于一个值需要进行比较，将右边的再进行一轮快速排序
        if (right < high) {
            quickSort(array, right + 1, high);
        }
    }
}
