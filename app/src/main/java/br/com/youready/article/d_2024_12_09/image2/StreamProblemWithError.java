package br.com.youready.article.d_2024_12_09.image2;

import java.util.List;

public class StreamProblemWithError {

    public static void main(String[] args) {
        // Temos um "oi" na lista
        final List<String> numbers = List.of("1", "2", "-32", "oi", "5", "100");

        // Imprime todos os números pares da lista
        numbers.stream()
                .map(Integer::parseInt) // LANÇA EXCEÇÃO!
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }
}
