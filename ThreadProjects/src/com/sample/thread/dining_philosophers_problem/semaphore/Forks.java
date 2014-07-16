
package com.sample.thread.dining_philosophers_problem.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class Forks {

    private static final int NUMBER_OF_FORKS = 5;

    private static final Semaphore forks = new Semaphore(NUMBER_OF_FORKS);

    /**
     * @return the forks
     */
    public static Semaphore getFork() {
        return forks;
    }

}
