package com.smart.sample.testutils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class TestUtils {

    private static TestUtils INSTANCE = new TestUtils();

    private TestUtils() {

    }

    public static <T> T loadJson(String path, Type type) {
        String json = loadJson(path);
        return (T) new Gson().fromJson(json, type);
    }

    public static <T> T loadJson(String path, Class<T> clazz) {
        String json = loadJson(path);
        return new Gson().fromJson(json, clazz);
    }

    public static String loadJson(String path) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    TestUtils.class.getClassLoader().getResourceAsStream(path)));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not read from resource at: " + path);
        }
    }
}
