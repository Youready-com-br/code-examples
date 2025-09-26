package br.com.youready.article.d_2025_05_01.image6;

import java.util.List;

class Nota {
    // Placeholder for Nota class
}

/*
 * Interface especifica para consulta de notas
 */
interface AlunoComNotas {
    String imprimeNotas();
}

/*
 * Interface especifica para adicionar notas
 */
interface AlunoParaDarNota {
    void adicionaNota(Nota nota);
}

// Removo o 'public' da classe para ninguém ter acesso
class Aluno implements AlunoComNotas, AlunoParaDarNota {
    private List<Nota> notas;

    // Alunos e professores podem acessar
    public String imprimeNotas() {
        return "";
    }

    // Somente professor pode acessar
    public void adicionaNota(Nota nota) {
        /* ... */
    }
}

interface AlunoService {
    AlunoComNotas buscaPorNome(String nome);
}

interface AlunoParaProfessoresService {
    AlunoParaDarNota buscaPorNome(String nome);
}
