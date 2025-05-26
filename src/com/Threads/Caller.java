package com.Threads;

public class Caller implements Runnable{

    String msg;
    final CallMe target;
    public Thread t;

    public Caller(CallMe targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    public void run(){
        synchronized (target) {
            target.call(msg);
        }
    }
}
