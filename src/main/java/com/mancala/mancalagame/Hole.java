package com.mancala.mancalagame;

public class Hole {
    private int count;

    public Hole(int count) {
        this.count = count;
    }

    public void setCount(int newCount) {
        count = newCount;
    }

    public int getCount() {
        return count;
    }
}
