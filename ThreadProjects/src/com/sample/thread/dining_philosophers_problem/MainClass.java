
package com.sample.thread.dining_philosophers_problem;

/**
 *
 */
public class MainClass {

    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Thread phil_1 = new Thread(new Philosopher(fork1, fork2), "Philosopher-1");
        Thread phil_2 = new Thread(new Philosopher(fork2, fork3), "Philosopher-2");
        Thread phil_3 = new Thread(new Philosopher(fork3, fork4), "Philosopher-3");
        Thread phil_4 = new Thread(new Philosopher(fork4, fork5), "Philosopher-4");
        Thread phil_5 = new Thread(new Philosopher(fork5, fork1), "Philosopher-5");

        phil_4.start();
        phil_5.start();
        phil_1.start();
        phil_2.start();
        phil_3.start();

    }

}
