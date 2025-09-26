package br.com.youready.article.d_2024_12_09.image6;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> numbers = List.of("1", "2", "-32", "oi", "5", "100");

        numbers.stream().map(TryTo::parseInt).filter(number -> number % 2 == 0).forEach(System.out::println);
    }

    static class TryTo {
        // Vamos implementar a funcao Try aqui!
        static int parseInt(String text) {
            return Integer.parseInt(text);
        }
    }
}
