package com.deeparishi.javaapp.corejavaconcepts.concurrency.future;

import java.util.concurrent.Callable;

public class CallableTask<T> implements Callable<T> {

    private final T value;

    public CallableTask(T value) {
        this.value = value;
    }

    @Override
    public T call() throws Exception {
        return value;
    }
}
