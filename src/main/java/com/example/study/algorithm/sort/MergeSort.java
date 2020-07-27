package com.example.study.algorithm.sort;

import java.util.Arrays;

/**
 * 归并算法
 *
 * @author lixiaoxiang
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左边归并排序，使得左子序列有序
            sort(arr, left, mid, temp);
            // 右边归并排序，使得右子序列有序
            sort(arr, mid + 1, right, temp);
            // 将两个有序子数组合并操作
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        // 临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            // 将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            // 将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
