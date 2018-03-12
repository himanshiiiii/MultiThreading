package com.ttn;

//Print Odd and even numbers from 1 to 20 in ascending order using two threads;
public class Q1 {

    boolean even;

    public  synchronized  void printOdd() {



            for (int i = 1; i <= 19; i = i + 2) {

                if(!even) {
                    System.out.print(i+" ");

                    try {
                        even=true;
                        notify();
                        wait();

                    } catch (Exception ex) {

                    }
                }

            }


}

    public void printEven() {

        try {
            Thread.sleep(100);
        }
        catch (Exception e)
        {

        }
        synchronized (this){
            if(even)
            {

                for (int i = 2; i <= 20; i = i + 2) {

                    System.out.print(i+" ");
                    try {
                        even=false;

                        notify();
                        wait();


                    }
                    catch (Exception ex){

                    }

                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Q1 q1=new Q1();
        q1.even=false;
        Thread odd = new Thread(q1::printOdd);
        Thread even=new Thread(q1::printEven);

        odd.start();
        even.start();


    }

}
