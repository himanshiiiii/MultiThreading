package com.ttn;

public class Q6 {

    public static void main(String[] args) throws InterruptedException {

        int arr[] = {1, 3, 4, 2, 44, 22, 77, 99, 88, 99, 33, 35, 56, 57, 21, 22};


        MaxThread s1 = new MaxThread(arr, 0);

        Thread thread = new Thread(s1);

        thread.start();

        MaxThread s2 = new MaxThread(arr, 4);

        Thread thread1 = new Thread(s2);

        thread1.start();

        MaxThread s3 = new MaxThread(arr, 8);

        Thread thread2 = new Thread(s3);

        thread2.start();

        MaxThread s4 = new MaxThread(arr, 11);

        Thread thread3 = new Thread(s4);

        thread3.start();


        Thread.sleep(500);

        int maxArr[] = {s1.getMax(), s2.getMax(), s3.getMax(), s4.getMax()};

        MaxThread maxThread = new MaxThread(maxArr, 0);

        Thread finalMax = new Thread(maxThread);

        finalMax.start();

        finalMax.join();

        System.out.println("Max : " + maxThread.getMax());


    }


}


class MaxThread implements Runnable {


    int arr[];

    int index;

    int max;

    public MaxThread(int[] arr, int index) {

        this.arr = arr;

        this.index = index;

    }


    public int getMax() {

        return max;

    }


    @Override

    public void run() {

        max();

    }


    void max() {

        max = -1;

        for (int i = index; i < index + 3; i++) {

            if (arr[i] > max)

                max = arr[i];

        }



    }

}
