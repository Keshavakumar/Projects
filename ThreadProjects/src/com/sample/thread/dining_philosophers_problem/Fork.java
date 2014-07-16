
package com.sample.thread.dining_philosophers_problem;

/**
 *
 */
public class Fork {

    private int forkNumber = 0;

    Fork(int number) {
        forkNumber = number;
    }

    /**
     * @return the forkNumber
     */
    public int getForkNumber() {
        return forkNumber;
    }

}
