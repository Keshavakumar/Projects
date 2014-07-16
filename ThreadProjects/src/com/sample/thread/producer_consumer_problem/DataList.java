/*
 * Copyright (c) Advanced Driver Information Technology
 */

package com.sample.thread.producer_consumer_problem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DataList {

    private int SIZE_OF_LIST = 2;

    protected List<Integer> DATA_LIST = new ArrayList<Integer>(getSIZE_OF_LIST());

    /**
     * @return the DATA_LIST
     */
    public List getDataList() {
        return DATA_LIST;
    }

    /**
     * @param dataList the DATA_LIST to set
     */
    public void setDataList(List dataList) {
        this.DATA_LIST = dataList;
    }

    /**
     * @return the SIZE_OF_LIST
     */
    public int getSIZE_OF_LIST() {
        return SIZE_OF_LIST;
    }

}
