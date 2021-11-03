package com.spring.professional.exam.tutorial.module05.question10.ds;

public class MutableCountHolder {
    private int count;

    public int get() {
        return count;
    }

    public int increment() {
        return ++count;
    }
}
