package com.eknaij.sort;

import java.util.Arrays;

/**
 * @Author Eknaij
 * @Date 2020/9/30 16:38
 * @Description 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {135, 5, 87, 517, 135, 157, 32, 45, 4, 1};
        heapSort(arr);
    }


    public static void heapSort(int arr[]) {
        int count = 1;
        //1.构建最大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
            System.out.println("第 " + (count++) + " 次调整后：" + Arrays.toString(arr));
        }
        //2.将最大顶堆的堆顶元素与末尾元素进行交换，将最大的元素放置末尾
        //3.最大元素沉到末尾后，需要继续调整最大顶堆使得结构一致，然后重复2步骤直到整个序列有序
        count = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //由于每次交换后最大的数都沉底了，因此长度会少1
            adjustHeap(arr, 0, i);
            System.out.println("第 " + (count++) + " 次交换并且调整后：" + Arrays.toString(arr));
        }
        //排序后
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 将以i为根节点对应的子树调整成最大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        //先取出当前元素的值， 保存在临时变量
        int temp = arr[i];
        //每次循环都从左子树开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //根据顺序存储二叉树的概念,i*2+1是第i个结点的左子节点

            if (k + 1 < length && arr[k] < arr[k + 1]) { //当前节点的右子节点大于左子节点
                k++;//实际k变成了k=i*2+2,是第i个结点的右子节点
            }
            if (arr[k] > temp) {//如果左节点和右节点较大的那个比当前节点（父节点）大
                arr[i] = arr[k];//把较大的值赋给当前（父）节点，此时子树的父节点为最大,arr[k]的值还需要交换
                //将i指向交换后的位置
                i = k;
            } else {
                //否则的话不需要进行交换
                break;
            }
        }
        //当for循环结束后，以i为父节点的子树的最大值已经在子树的根节点，但前面说的arr[k]的值还没有进行交换，
        // 但是已经有了指向需要进行交换位置的指针，所以直接交换即可
        arr[i] = temp;
    }
}
