package com.andrei.learning;

public class EvenNumbersThreadRunnable implements Runnable {
    EvenNumbersThreadRunnable() {
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < 20; i += 2) {
                System.out.println("In evenTnumbersThread: " + i + " ");
                Thread.sleep(200);
            }
        }
        catch(InterruptedException e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
