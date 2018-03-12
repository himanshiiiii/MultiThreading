package com.ttn;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Q8 {
    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

    public void subscriber() {
        for (int i = 0; i < 10; i++) {
            String message = "";
            try {
                message = queue.take();
            } catch (InterruptedException e) {
            }
            System.out.println(i + ". Message subscribed..." + message);
        }
    }

    public void publisher() {
        for (int i = 0; i < 10; i++) {
            String message = UUID.randomUUID().toString();
            try {
                queue.put(message);
            } catch (InterruptedException e) {
            }
            System.out.println(i + ". Message published..." + message);
        }
    }

    public static void main(String[] args) {
        Q8 q8=new Q8();
        Thread thread1=new Thread(q8::subscriber);
        Thread thread2=new Thread(q8::publisher);
        thread1.start();
        thread2.start();
    }
        }
