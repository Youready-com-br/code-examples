package br.com.youready.article.d_2025_02_11.image10;

import java.util.ArrayList;
import java.util.List;

interface Profissional {
    void executa();
}

class EquipeAgil {
    private final List<Profissional> profissionais = new ArrayList<>();

    public void simulaUmDiaDeTrabalho() {
        for (Profissional profissional : profissionais) {
            profissional.executa();
        }
    }

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

class GerenteDeProduto implements Profissional {
    public void gerencia() {
        System.out.println("Gerenciando");
    }

    @Override
    public void executa() {
        this.gerencia();
    }
}
