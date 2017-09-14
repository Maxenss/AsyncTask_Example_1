package com.easylabs.asynctask_example_1;

/**
 * Created by Maxim on 14.09.2017.
 */

public class Counter {
   private int count;
   private String name;

    public Counter() {

    }

    public Counter(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
