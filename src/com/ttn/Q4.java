package com.ttn;

public class Q4 {
    static Integer count = 0;

    public static void createThread() {
        count += 1;
        Thread.currentThread().setName(count.toString());

        if(count <= 10) {
            Thread thread = new Thread(() -> createThread());

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread :" + Thread.currentThread().getName() + " prints Hello World");

        }
    }

    public static void main(String[] args) {
        createThread();
    }
}
