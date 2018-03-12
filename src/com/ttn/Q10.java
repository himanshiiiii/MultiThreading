package com.ttn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q10 {
     public static void main(String[] args) {
            final ExecutorService executor = Executors.newFixedThreadPool(2);
            final Counter c = new Counter();
            for (int i = 0; i < 5; i++) {
                final Runnable worker = new WorkerThread(c);
                executor.execute(worker);
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }

            System.out.println(c.getCount());
        }

    }

    class WorkerThread implements Runnable {
        Counter c;

        public WorkerThread(Counter counter) {
            this.c = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                c.inc();
            }
        }

    }

    class Counter {

        static int count = 0;

        public synchronized void inc() {
            count++;
        }

        public int getCount() {
            return this.count;
        }

    }

