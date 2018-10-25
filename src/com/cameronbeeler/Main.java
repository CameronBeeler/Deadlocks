package com.cameronbeeler;

public class Main
{

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args)
    {
        new Thread1().start();
        new Thread2().start();
        // write your code here
    }

    private static class Thread1 extends Thread
    {
        public void run()
        {
            synchronized (lock1)
            {
                System.out.println("Thread 1:  has lock1");
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException i)
                {
                    i.printStackTrace();
                }
                System.out.println("Thread 1:  Waiting for lock 2");
                synchronized (lock2)
                {
                    System.out.println("Thread 1:  Has lock 1 & lock 2");
                }
                System.out.println("Thread 1: Released lock 2.");
            }
            System.out.println("Thread 1: Released lock 1.  Exiting...");

        }
    }

    private static class Thread2 extends Thread
    {
        public void run()
        {
            synchronized (lock2)
            {
                System.out.println("Thread 2:  has lock 2");
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException i)
                {

                }
                System.out.println("Thread 2:  Waiting for lock 1");
                synchronized (lock1)
                {
                    System.out.println("Thread 2:  Has lock2 and lock1");
                }
                System.out.println("Thread 2:  release lock1");
            }
            System.out.println("Thread 2: Released lock2.  Exiting...");
        }
    }
}


