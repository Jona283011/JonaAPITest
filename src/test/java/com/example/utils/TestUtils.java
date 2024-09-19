package com.example.utils;

public class TestUtils {

    public final static ThreadLocal<TestContextHolder> contextHolder = new ThreadLocal<>();

    public static TestContextHolder getContext(){
        return contextHolder.get();
    }
}
