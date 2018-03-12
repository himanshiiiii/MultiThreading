package com.ttn;

public class Q7 {
    static int n=0;
    public static boolean isfull(){
        if(n==10)
            return true;
        return false;
    }

    public static boolean isEmpty(){
        if(n==0)
            return true;
        return false;
    }

    public  void produce(){
        while(true) {
            synchronized (this) {
                while (isfull())
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                n += 1;
                System.out.println("producer:" + n);
                notifyAll();

            }
        }
    }

    public  void consume(){

        while(true) {
            synchronized (this) {
                while (isEmpty())
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                n -= 1;
                System.out.println("Consumer :" + n);
                notifyAll();

            }
        }
    }

    public static void main(String[] args) {
        Q7 obj=new Q7();
        Thread producer=new Thread(obj::produce);
        Thread consume=new Thread(obj::consume);
        producer.start();
        consume.start();
    }

}
