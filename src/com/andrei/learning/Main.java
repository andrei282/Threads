package com.andrei.learning;

public class Main {

    public static void main(String[] args) {

        /*OddNumbersThread oddThread = new OddNumbersThread();
        EvenNumbersThreadRunnable evenThreadRunnable = new EvenNumbersThreadRunnable();
        Thread thread = new Thread(evenThreadRunnable);

        oddThread.start();
        thread.start();

        System.out.println("THE END");*/

        PrintDemo printDemo = new PrintDemo();
        ThreadDemo threadDemo1 = new ThreadDemo("Thread - 1", printDemo);
        ThreadDemo threadDemo2 = new ThreadDemo("Thread - 2", printDemo);

        threadDemo1.start();
        threadDemo2.start();

        try{
            threadDemo1.join();
            threadDemo2.join();
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
