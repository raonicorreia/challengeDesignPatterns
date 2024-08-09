package com.dio.challenge.common;

import java.util.HashSet;
import java.util.stream.Collectors;

public class AppUtil {

    private AppUtil(){
    }

    public static String numbersToString(HashSet<Integer> numbers) {
        // HasSet me garante a ordem correta dos números
        return String.join(";", numbers.stream()
                .map(number -> Integer.toString(number))
                .collect(Collectors.toList()));
    }
}
