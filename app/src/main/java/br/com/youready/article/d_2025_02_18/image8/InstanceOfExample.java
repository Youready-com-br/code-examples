package br.com.youready.article.d_2025_02_18.image8;

class A {
    // ...
}

class B extends A {
    void executaMetodoQueExisteSoNoB() {
        // ...
    }
}

public class InstanceOfExample {
    void recebeAMasQueroFazerCoisaDoB(A a) {
        if (a instanceof B) {
            B b = (B) a;
            b.executaMetodoQueExisteSoNoB();
        }
    }
}
