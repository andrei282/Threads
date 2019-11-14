package com.andrei.learning;

public class OddNumbersThread extends Thread {
    OddNumbersThread(){};

    @Override
    public void run() {
        try{
            for(int i = 1; i < 20; i += 2) {
                System.out.println("In oddNumbersthread: " + i + " ");
                Thread.sleep(200);
            }
        }
        catch(InterruptedException e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
