package br.com.youready.article.d_2025_02_18.image9;

import groovy.lang.Delegate;

class A {
    void reaproveita() {
        // ...
    }
}

class B {
    // Anotacao da Linguagem Groovy
    @Delegate
    A a = new A()
}
