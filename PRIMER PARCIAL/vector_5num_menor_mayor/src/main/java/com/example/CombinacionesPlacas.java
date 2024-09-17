package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinacionesPlacas {
    public static void main(String[] args) {
        List<String> letras = Arrays.asList("A", "B");
        List<String> numeros = Arrays.asList("1", "2", "3");

        List<String> combinaciones = new ArrayList<>();
        for (String letra1 : letras) {
            for (String letra2 : letras) {
                if (!letra1.equals(letra2)) {
                    List<String> elementos = new ArrayList<>(numeros);
                    List<List<String>> permutacionesNumeros = permutacionesNumeros(elementos, 0);
                    for (List<String> perm : permutacionesNumeros) {
                        String placa = letra1 + letra2 + String.join("", perm);
                        combinaciones.add(placa);
                    }
                }
            }
        }

        combinaciones.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static List<List<String>> permutacionesNumeros(List<String> numeros, int index) {
        List<List<String>> combinaciones = new ArrayList<>();
        if (index == numeros.size() - 1) {
            combinaciones.add(new ArrayList<>(numeros));
            return combinaciones;
        }
        for (int i = index; i < numeros.size(); i++) {
            Collections.swap(numeros, i, index);
            combinaciones.addAll(permutacionesNumeros(numeros, index + 1));
            Collections.swap(numeros, i, index);
        }
        return combinaciones;
    }
}
