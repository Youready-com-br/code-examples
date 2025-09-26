package br.com.youready.article.d_2025_02_18.image7;

/**
 * Faz composicao
 * @ quebra OCP + DRY?
 */
class A1 {
    void reaproveita() {
        // ...
    }
}

class B1 {
    A1 a = new A1();

    void reaproveita() {
        a.reaproveita();
    }
}
