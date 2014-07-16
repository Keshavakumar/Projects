
package com.sample.thread.dining_philosophers_problem;

/**
 *
 */
public class Philosopher implements Runnable {

    private Fork leftFork;

    private Fork rightFork;

    Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void process() {
        synchronized (leftFork) {
            synchronized (rightFork) {
                System.out.println("Eating now . . " + Thread.currentThread().getName() + "with " + "Fork " + leftFork.getForkNumber() + "and " + rightFork.getForkNumber());
            }

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            process();
        }
    }

}
