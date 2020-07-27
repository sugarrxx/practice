package com.example.study.datastructures.tree;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author <a>lxx</a>
 * @date 2020-02-20
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        System.out.println("堆排序");
        int temp;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("调整后数组" + Arrays.toString(arr));
    }

    /**
     * 将数组(二叉树)调整为大顶堆
     *
     * @param arr 待调整数组
     * @param i 非叶子结点在数组中的索引
     * @param length 对多少个元素进行调整(逐渐减少)
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
