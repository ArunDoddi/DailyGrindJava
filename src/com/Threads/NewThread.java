package com.Threads;

public class NewThread implements Runnable{

    public Thread t;

    public NewThread(){
        t = new Thread(this, "Demo_Thread");
        System.out.println("Child thread: " +t);
    }

    public void run(){
        try{
            for( int i = 5; i>=0; i--){
                System.out.println("Child Thread: " +i+ " "+t.getName());
                Thread.sleep(1500);
            }
            System.out.println("Child Thread exiting");
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted");;
        }
        System.out.println("Main Thread exiting");
    }
}
