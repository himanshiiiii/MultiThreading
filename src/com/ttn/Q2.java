package com.ttn;

// Print Prime and non-prime numbers from 1 to 20 in ascending order using two threads;
public class Q2 {

    boolean prime=true;
    int count=1;
    boolean flag=false;
    static int i=1;

    public  boolean isPrime(int n) {
        int temp;
        prime=true;
        for(int j=2;j<=n/2;j++)
        {
            temp=n%j;
            if(temp==0)
            {
                prime=false;
                break;
            }
        }
        return  prime;
    }


    public  synchronized  void prime() {



        for (; i <= 20; i++) {

            if(isPrime(i)) {
                System.out.print(i + " ");

            }
            else{
                try {
                    i--;
                    notify();
                    wait();

                } catch (Exception ex) {

                }
            }

        }


    }

    public void nonprime() {

        try {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {

        }
        synchronized (this){
                for (; i <= 20; i++) {

                    if(!isPrime(i)) {
                        System.out.print(i + " ");
                        flag=true;
                    }
                    else{
                        if(flag) {
                            try {
                                i--;
                                notify();
                                wait();

                            } catch (Exception ex) {

                            }
                        }
                    }

                }



        }
    }

    public static void main(String[] args) throws Exception {
        Q2 q2=new Q2();
        q2.prime=false;
        Thread prime = new Thread(q2::prime);
        Thread nonPrime=new Thread(q2::nonprime);

        prime.start();
        nonPrime.start();


    }


}
