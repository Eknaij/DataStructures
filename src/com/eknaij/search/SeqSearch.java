package com.eknaij.search;

/**
 * @Author Eknaij
 * @Date 2020/9/18 14:17
 * @Description 顺序查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};
        System.out.println(seqSearch(arr,135));
    }


    /**
     *
     * @param arr   待查找的数组
     * @param target    需要查找的值
     * @return
     */
    public static int seqSearch(int[] arr,int target){
        //线性查找，遍历数组，找到相应的值后返回下标,如果有多个值，只返回第一个
        for (int i = 0; i < arr.length; i++) {
            if (target==arr[i])
                return i;
        }
        return -1;
    }
}
