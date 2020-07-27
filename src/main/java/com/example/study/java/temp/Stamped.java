package com.example.study.java.temp;

import java.util.concurrent.locks.StampedLock;

/**
 * @author <a href="mailto:lixiaoxiang@vpgame.cn">lxx</a>
 * @date 2019-10-15
 */
public class Stamped {

    public static void main(String[] args) {

    }

    class Point {

        private double x, y;
        private final StampedLock sl = new StampedLock();

        void move(double deltaX, double deltaY) { // an exclusively locked method
            long stamp = sl.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                sl.unlockWrite(stamp);
            }
        }

        /**
         * 其中主要是acquireWrite()
         * 自旋入队，如果没
         */

        double distanceFromOrigin() { // A read-only method
            long stamp = sl.tryOptimisticRead();
            double currentX = x, currentY = y;
            if (!sl.validate(stamp)) {
                stamp = sl.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        void moveIfAtOrigin(double newX, double newY) { // upgrade
            // Could instead start with optimistic, not read mode
            long stamp = sl.readLock();
            try {
                while (x == 0.0 && y == 0.0) {
                    long ws = sl.tryConvertToWriteLock(stamp);
                    if (ws != 0L) {
                        stamp = ws;
                        x = newX;
                        y = newY;
                        break;
                    } else {
                        sl.unlockRead(stamp);
                        stamp = sl.writeLock();
                    }
                }
            } finally {
                sl.unlock(stamp);
            }
        }
    }

//    class Point {
//
//        /**
//         * 成员变量
//         */
//        private double x, y;
//
//        /**
//         * 锁实例
//         */
//        private final StampedLock sl = new StampedLock();
//
//        /**
//         * 排它锁-写锁（writeLock）
//         */
//        void move(double deltaX, double deltaY) {
//            long stamp = sl.writeLock();
//            try {
//                x += deltaX;
//                y += deltaY;
//            } finally {
//                sl.unlockWrite(stamp);
//            }
//        }
//
//        /**
//         * 乐观读锁（tryOptimisticRead）
//         */
//        double distanceFromOrigin() {
//
//            // 尝试获取乐观读锁（1）
//            long stamp = sl.tryOptimisticRead();
//            // 将全部变量拷贝到方法体栈内（2）
//            double currentX = x, currentY = y;
//            // 检查在（1）获取到读锁票据后，锁有没被其他写线程排它性抢占（3）
//            if (!sl.validate(stamp)) {
//                // 如果被抢占则获取一个共享读锁（悲观获取）（4）
//                stamp = sl.readLock();
//                try {
//                    // 将全部变量拷贝到方法体栈内（5）
//                    currentX = x;
//                    currentY = y;
//                } finally {
//                    // 释放共享读锁（6）
//                    sl.unlockRead(stamp);
//                }
//            }
//            // 返回计算结果（7）
//            return Math.sqrt(currentX * currentX + currentY * currentY);
//        }
//
//        /**
//         * 使用悲观锁获取读锁，并尝试转换为写锁
//         */
//        void moveIfAtOrigin(double newX, double newY) {
//            // 这里可以使用乐观读锁替换（1）
//            long stamp = sl.readLock();
//            try {
//                // 如果当前点在原点则移动（2）
//                while (x == 0.0 && y == 0.0) {
//                    // 尝试将获取的读锁升级为写锁（3）
//                    long ws = sl.tryConvertToWriteLock(stamp);
//                    // 升级成功，则更新票据，并设置坐标值，然后退出循环（4）
//                    if (ws != 0L) {
//                        stamp = ws;
//                        x = newX;
//                        y = newY;
//                        break;
//                    } else {
//                        // 读锁升级写锁失败则释放读锁，显示获取独占写锁，然后循环重试（5）
//                        sl.unlockRead(stamp);
//                        stamp = sl.writeLock();
//                    }
//                }
//            } finally {
//                // 释放锁（6）
//                sl.unlock(stamp);
//            }
//        }
//    }
    }
