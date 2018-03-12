package com.ttn;

public class Q9 {
    public static void main(String[] args) {



           final Thread t1 = new Thread(() -> printOdd());
            t1.start();
            final Thread t2 = new Thread(() -> printEven());
            t2.start();

    }

    public static synchronized void printOdd () {

        for (int i = 1; i <= 4; i = i + 2) {

            for (int j = i; j <= 10; j = j + 4) {
                System.out.println("Thread " + i + ": " + j);
            }

        }

    }

    public static synchronized void printEven () {

        int count = 2;

        for (int i = 2; i <= 4; i = i + 2) {

            if (count > 10) {
                break;
            }

            System.out.println("Thread " + i + ": " + count);
            count = count + 2;
            if (i == 4) {
                i = i - 4;
            }

        }
    }

}
