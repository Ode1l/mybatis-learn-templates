package com.iris.utils;

import org.junit.Test;

import java.util.UUID;

public class IdUtils {
    public static String getId() {
        return UUID.randomUUID().toString();
    }
    @Test
    public void test() {
        System.out.println(getId());
    }
}
