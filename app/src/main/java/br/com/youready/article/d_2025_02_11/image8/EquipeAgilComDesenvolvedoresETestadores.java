package br.com.youready.article.d_2025_02_11.image8;

import java.util.ArrayList;
import java.util.List;

class EquipeAgil {
    private final List<Desenvolvedor> desenvolvedores = new ArrayList<>();
    private final List<Testador> testadores = new ArrayList<>();

    public void simulaUmDiaDeTrabalho() {
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            desenvolvedor.desenvolve();
        }
        // Para cada novo perfil, preciso adicionar um novo loop
        for (Testador testador : testadores) {
            testador.testa();
        }
    }

    public void adicionaDesenvolvedor(Desenvolvedor desenvolvedor) {
        desenvolvedores.add(desenvolvedor);
    }

    // Para cada novo perfil, preciso criar um método para adiciona
    public void adicionaTestador(Testador testador) {
        testadores.add(testador);
    }
}

class Desenvolvedor {
    public void desenvolve() {
        System.out.println("Desenvolvendo");
    }
}

class Testador {
    public void testa() {
        System.out.println("Testando");
    }
}
