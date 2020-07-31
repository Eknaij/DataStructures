package com.eknaij.sort;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @Author Eknaij
 * @Date 2020/7/28 11:04
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {135, 5, 87, -87, 517, 135, 157, 32, 45, 4, 1};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        /* 每趟排序的结果步骤


        int temp = 0;

        // 第一趟排序，就是将第一大的数排在倒数第一位

        for (int j = 0; j < arr.length - 1 ; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

		// 第二趟排序，就是将第二大的数排在倒数第二位

		for (int j = 0; j < arr.length - 1 - 1 ; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第二趟排序后的数组");
		System.out.println(Arrays.toString(arr));


		// 第三趟排序，就是将第三大的数排在倒数第三位

		for (int j = 0; j < arr.length - 1 - 2; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第三趟排序后的数组");
		System.out.println(Arrays.toString(arr));

		// 第四趟排序，就是将第4大的数排在倒数第4位

		for (int j = 0; j < arr.length - 1 - 3; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第四趟排序后的数组");
		System.out.println(Arrays.toString(arr));
        */


        bubbleSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] array) {
        if (array.length == 0 || array == null) {
            return array;
        }
        int temp = 0;
        boolean flag = false; // 标识变量， 表示是否进行过交换
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) { // 在一趟排序中， 一次交换都没有发生过，表明数组已经排序完毕了
                break;
            } else {
                flag = false; // 重置 flag!!!, 进行下次判断
            }
        }
        return array;
    }
}
