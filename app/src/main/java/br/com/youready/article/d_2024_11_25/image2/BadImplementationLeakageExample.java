package br.com.youready.article.d_2024_11_25.image2;

import java.util.ArrayList;
import java.util.List;

public class BadImplementationLeakageExample {

    public List<String> exemploRuimDeVazamentoDeImplementacao() {
        List<String> lista = new ArrayList<>();
        lista.add("a");
        lista.add("b");
        lista.add("c");

        // ...

        // Ruim: Retorna a implementação específica, vazando o detalhe de que é um ArrayList
        return lista;
    }
}
