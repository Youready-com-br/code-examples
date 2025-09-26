package br.com.youready.article.d_2025_02_11.image7;

import java.util.ArrayList;
import java.util.List;

class EquipeAgil {
    private final List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public void simulaUmDiaDeTrabalho() {
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            desenvolvedor.desenvolve();
        }
    }

    public void adicionaDesenvolvedor(Desenvolvedor desenvolvedor) {
        desenvolvedores.add(desenvolvedor);
    }
}

class Desenvolvedor {
    public void desenvolve() {
        System.out.println("Desenvolvendo");
    }
}
