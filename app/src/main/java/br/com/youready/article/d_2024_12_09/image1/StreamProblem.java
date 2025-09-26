package br.com.youready.article.d_2024_12_09.image1;

import java.util.List;

public class StreamProblem {

    public static void main(String[] args) {
        final List<String> numbers = List.of("1", "2", "-32", "5", "100");

        // Imprime todos os números pares da lista
        numbers.stream()
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }
}
