package com.eknaij.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Eknaij
 * @Date 2020/9/18 14:26
 * @Description 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};
        //要使用二分查找，序列必须是有序的，因此先进行排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 157));
        System.out.println(binarySearch(arr, 157, 0, 10));
        System.out.println(insertValueSearch(arr, 157, 0, 10));
    }

    /**
     * @param arr    待查找的数组,已排序
     * @param target 需要查找的值
     * @return
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left < right) {
            //移位求mid
            int mid = (left + right) >>> 1;
            if (target == arr[mid])
                return mid;
            else if (target < arr[mid])
                ////需要查找的值在序列的左边
                right = mid - 1;
            else
                //需要查找的值在序列的右边
                left = mid + 1;
        }
        return -1;
    }

    /**
     * @param arr    已排序的数组
     * @param target 目标值
     * @param left   左指针
     * @param right  右指针
     * @return
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;
        int mid = (left + right) >>> 1;
        if (arr[mid] > target) {
            return binarySearch(arr, target, mid + 1, right);
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int target, int left, int right) {
        // 当 left > right 时， 说明递归整个数组， 但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (target > midVal) { // 向 右递归
            return binarySearch2(arr, target, mid + 1, right);
        } else if (target < midVal) { // 向左递归
            return binarySearch2(arr, target, left, mid - 1);
        } else {
            // * 思路分析
            // * 1. 在找到 mid 索引值， 不要马上返回
            // * 2. 向 mid 索引值的左边扫描， 将所有满足 1000， 的元素的下标， 加入到集合 ArrayList
            // * 3. 向 mid 索引值的右边扫描， 将所有满足 1000， 的元素的下标， 加入到集合 ArrayList
            // * 4. 将 Arraylist 返回
            List<Integer> resIndexlist = new ArrayList<Integer>();
            //向 mid 索引值的左边扫描， 将所有满足 1000， 的元素的下标， 加入到集合 ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != target) {//退出
                    break;
                }
                //否则，就 temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp 左移
            }
            resIndexlist.add(mid); //
            //向 mid 索引值的右边扫描， 将所有满足 1000， 的元素的下标， 加入到集合 ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != target) {//退出
                    break;
                } //否则，就 temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp 右移
            }
            return resIndexlist;
        }
    }

    public static int insertValueSearch(int[] arr, int target, int left, int right) {
        //防止越界
        if (left > right || target > arr[right] || target < arr[left])
            return -1;
//        int mid = (left + right) >>> 1;
        int mid = left + (target - arr[left]) * (right -left ) / (arr[right] - arr[left]);
        if (arr[mid] > target) {
            return binarySearch(arr, target, mid + 1, right);
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right);
        } else {
            return mid;
        }
    }
}
