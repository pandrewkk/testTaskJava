package com.andrey.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
