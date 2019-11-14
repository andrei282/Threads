package com.andrei.learning;
// Multithreading with/without synchronization

/*
* When we start two or more threads within a program, there may be a situation when multiple threads try to access the
* same resource and finally they can produce unforeseen result due to concurrency issues. For example, if multiple
* threads try to write within a same file then they may corrupt the data because one of the threads can override data
* or while one thread is opening the same file at the same time another thread might be closing the same file.

So there is a need to synchronize the action of multiple threads and make sure that only one thread can access the
* resource at a given point in time. This is implemented using a concept called monitors. Each object in Java is
* associated with a monitor, which a thread can lock or unlock. Only one thread at a time may hold a lock on a monitor.

Java programming language provides a very handy way of creating threads and synchronizing their task by using
* synchronized blocks. You keep shared resources within this block. Following is the general form of the synchronized
* statement −
* synchronized(objectidentifier) {
   // Access shared variables and other shared resources
}
* Here, the objectidentifier is a reference to an object whose lock associates with the monitor that the
* synchronized statement represents
* */

public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    private final PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo printDemo){
        threadName = name;
        this.printDemo = printDemo;
    }

    public void run(){
        //printDemo.printCount(threadName); //without sync
        synchronized (printDemo){ // with sync
            printDemo.printCount(threadName);
        }
        System.out.println("Thread " + threadName + " exiting");
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class PrintDemo{
    public void printCount(String threadName) {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Thread " + threadName + "   ---   Counter   ---   "  + i );
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}
