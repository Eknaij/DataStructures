package com.eknaij.search;

import java.util.Arrays;

/**
 * @Author Eknaij
 * @Date 2020/9/21 9:53
 * @Description 斐波那契查找
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(fibSearch(arr, 517));
    }


    //获取一个斐波那契数列
    public static int[] fib() {
        //斐波那契数列的长度先定为20
        int f[] = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 1];
        }
        return f;
    }

    public static int fibSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        //获取一个斐波那契数列
        int[] f = fib();
        //k记录斐波那契数列的下标
        int k = 0;
        //用循环来判断数组的长度是不是斐波那契数列的某个值减一，循环结束后，f[k]就是最接近数组长度的斐波那契数
        while (arr.length > f[k] - 1)
            k++;
        //扩张数组的长度为f[k],后面用0填充
        int[] temp = Arrays.copyOf(arr, f[k] - 1);
        //将数组后的0复制为arr最后的数
        for (int i = high + 1; i < temp.length; i++)
            temp[i] = arr[high];
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (target < temp[mid]) {
                //说明目标值应该在左边
                high = mid - 1;
                k -= 1;
                //为什么是减一？
                //因为数组被拆分为两个部分,前一部分的元素是k-1个，所以可以继续拆分为f[k-1] = f[k -2] +f[k -3]
            } else if (target > temp[mid]) {
                low = mid + 1;
                k -= 2;
                //当k为0时，不能再进行分割，直接返回
                if (k == 0)
                    return low;
            } else {
                if (mid <= high)
                    return mid;
                else
                    return high;
            }
        }
        return -1;
    }
}
