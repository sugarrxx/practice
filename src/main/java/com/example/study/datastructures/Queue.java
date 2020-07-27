package com.example.study.datastructures;

/**
 * 队列
 *
 * @author <a href="mailto:lixiaoxiang@vpgame.cn">lxx</a>
 * @date 2020-02-09
 */
public class Queue {

    public static void main(String[] args) {

    }


}

class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        this.rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw  new RuntimeException("队列已空");
        }
        this.front++;
        return arr[front];
    }
}
