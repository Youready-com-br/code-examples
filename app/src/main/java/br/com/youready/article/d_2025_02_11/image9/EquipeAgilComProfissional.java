package br.com.youready.article.d_2025_02_11.image9;

import java.util.ArrayList;
import java.util.List;

interface Profissional {
    void executa();
}

// Nunca mais precisamos modificar esta classe
class EquipeAgil {
    private final List<Profissional> profissionais = new ArrayList<>();

    public void simulaUmDiaDeTrabalho() {
        // Nao importa o perfil, todos executam
        for (Profissional profissional : profissionais) {
            profissional.executa();
        }
    }

    // Nao importa o perfil, todos sao adicionados por este método
    public void adicionaProfissional(Profissional profissional) {
        profissionais.add(profissional);
    }
}

class Desenvolvedor implements Profissional {
    public void desenvolve() {
        System.out.println("Desenvolvendo");
    }

    @Override
    public void executa() {
        this.desenvolve();
    }
}

class Testador implements Profissional {
    public void testa() {
        System.out.println("Testando");
    }

    @Override
    public void executa() {
        this.testa();
    }
}
