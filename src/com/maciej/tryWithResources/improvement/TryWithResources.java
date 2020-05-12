package com.maciej.tryWithResources.improvement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    private void tryWithResources_Before_Java_9() throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("journaldev"));
        // We cannot use any Resource (which is declared outside the Try-With-Resources) within try() block of Try-With-Resources statement.
        // try (bufferedReader1) - this would throw compile-time error in Java 8
        try (BufferedReader bufferedReader2 = bufferedReader1) {
            System.out.println(bufferedReader2.readLine());
        }
    }

    private void tryWithResources_Java_9() throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("journaldev"));
        try (bufferedReader1) {
            System.out.println(bufferedReader1.readLine());
        }
    }
}
