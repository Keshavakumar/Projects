/*
 * Copyright (c) Advanced Driver Information Technology
 */

package com.sample.thread.producer_consumer_problem.semaphore;

/**
 *
 */
public class Producer extends Thread {
    
    ProcuctQueue q;
    
    public Producer(ProcuctQueue q) {
        this.q = q;
        this.setName("Producer Thread");
        this.start();
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            q.produce(i);
        }
        
    }
    
}
