package com.example.flatmap;

import java.util.List;

public class FlatMapUtil {

    private FlatMapUtil() {
    }

    public static List<String> toUpperCase(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return List.of(value.toUpperCase(), Thread.currentThread().getName());
    }

}
