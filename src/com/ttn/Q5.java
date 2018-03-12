package com.ttn;
//5. Create a program that calculates the sum of all the elements of
// an Array by using 4 threads.
public class Q5 {

    public static void main(String[] args) throws InterruptedException {

        int arr[]={1,1,1,1,1,1,1,1,1,1,1,1};



        SumThread s1=new SumThread(arr,0,0);

        Thread thread=new Thread(s1);

        thread.start();

        SumThread s2=new SumThread(arr,3,0);

        Thread thread1=new Thread(s2);

        thread1.start();

        SumThread s3=new SumThread(arr,6,0);

        Thread thread2=new Thread(s3);

        thread2.start();

        SumThread s4=new SumThread(arr,8,0);

        Thread thread3=new Thread(s4);

        thread3.start();



        Thread.sleep(1000);

        int sum=s1.getSum()+

                s2.getSum()+

                s3.getSum()+

                s4.getSum();

        System.out.println("Sum : "+sum);



    }



}



class SumThread implements Runnable{



    int arr[];

    int index;

    int sum;



    public SumThread(int[] arr, int index, int sum) {

        this.arr = arr;

        this.index = index;

        this.sum = sum;

    }



    public int getSum() {

        return sum;

    }



    @Override

    public void run() {

        sum();

    }



    void  sum(){

        for (int i = index; i <index+3 ; i++) {

            sum=sum+arr[i];

        }



        System.out.println("--"+sum);

    }



}
