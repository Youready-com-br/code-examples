package br.com.youready.article.d_2025_05_01.image5;

import java.util.List;

public class AlunoExample {

    public static class Aluno {
        private List<Nota> notas;

        public String imprimeNotas() {
            return "";
        }

        public void adicionaNota(Nota nota) {}
    }

    interface AlunoService {
        Aluno buscaPorNome(String nome);
    }

    static class Nota {}
}
