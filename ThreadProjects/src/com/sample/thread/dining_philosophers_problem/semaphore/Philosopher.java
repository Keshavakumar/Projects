
package com.sample.thread.dining_philosophers_problem.semaphore;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Philosopher extends Thread {

    public void process() {
        try {
            Forks.getFork().acquire(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("eating now " + Thread.currentThread().getName() + "   -->    no of permits left " + Forks.getFork().availablePermits());
        Forks.getFork().release(2);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            process();
        }
    }

}
