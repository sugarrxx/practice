package com.example.study.datastructures;

/**
 * 稀疏数组
 *
 * @author <a href="mailto:lixiaoxiang@vpgame.cn">lxx</a>
 * @date 2020-02-09
 */
public class SparseArray {

    public static void main(String[] args) {
        // 11 * 11 棋盘
        // 0没有棋子 1-黑色棋子 2-白色棋子
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        // 原始二维数组
        for (int[] ints : chessArray) {
            for (int i : ints) {
                System.out.printf("%s\t", i);
            }
            System.out.println();
        }

        // 转为稀疏数组
        // 1.先遍历 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            int[] ints = chessArray[i];
            for (int j = 0; j < ints.length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        // 用于记录是第几个非零数据
        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            int[] ints = chessArray[i];
            for (int j = 0; j < ints.length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("稀疏数组");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%s\t%s\t%s\t\n", sparseArray[i][0], sparseArray[i][1],
                    sparseArray[i][2]);
        }
    }
}
