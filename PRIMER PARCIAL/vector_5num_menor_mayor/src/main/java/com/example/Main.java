package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] numeros = { 1, 2, 3, 4, 5 };
        List<List<Integer>> combinaciones = new ArrayList<>();
        permutaciones(numeros, 0, combinaciones);
        combinaciones.stream()
                .map(c -> c.stream().reduce(0, (a, b) -> 10 * a + b))
                .sorted()
                .forEach(System.out::println);
    }

    private static void permutaciones(Integer[] numeros, int index, List<List<Integer>> combinaciones) {
        if (index == numeros.length - 1) {
            combinaciones.add(Arrays.asList(numeros.clone()));
            return;
        }
        for (int i = index; i < numeros.length; i++) {
            Collections.swap(Arrays.asList(numeros), i, index);
            permutaciones(numeros, index + 1, combinaciones);
            Collections.swap(Arrays.asList(numeros), i, index);
        }
    }
}
