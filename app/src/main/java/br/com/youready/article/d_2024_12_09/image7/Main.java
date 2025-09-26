package br.com.youready.article.d_2024_12_09.image7;

import io.vavr.control.Try;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> numbers = List.of("1", "2", "-32", "oi", "5", "100");

        numbers.stream().map(TryTo::parseInt).filter(number -> number % 2 == 0).forEach(System.out::println);
    }

    static class TryTo {
        private static int parseInt(String text) {
            // Utilizando o Try do VAVR para transformar em inteiro
            return Try.of(() -> Integer.parseInt(text))
                    // Fazer algo quando ocorre alguma excecao
                    .onFailure((e) -> System.out.println(e.getMessage()))
                    // Devolver o valor computado ou um valor padrao quando ocorre excecao.
                    // Aqui estamos devolvendo -1 que nao influencia nas proximas funcoes.
                    .getOrElse(-1);
        }
    }
}
