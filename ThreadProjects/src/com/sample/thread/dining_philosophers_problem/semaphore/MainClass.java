
package com.sample.thread.dining_philosophers_problem.semaphore;

/**
 *
 */
public class MainClass {

    public static void main(String[] args) {
        Thread phil_1 = new Thread(new Philosopher(), "Philosopher-1");
        Thread phil_2 = new Thread(new Philosopher(), "Philosopher-2");
        Thread phil_3 = new Thread(new Philosopher(), "Philosopher-3");
        Thread phil_4 = new Thread(new Philosopher(), "Philosopher-4");
        Thread phil_5 = new Thread(new Philosopher(), "Philosopher-5");

        phil_4.start();
        phil_5.start();
        phil_1.start();
        phil_2.start();
        phil_3.start();
    }

}
