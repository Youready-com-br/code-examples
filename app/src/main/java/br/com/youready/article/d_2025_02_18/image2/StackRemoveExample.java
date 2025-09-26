package br.com.youready.article.d_2025_02_18.image2;

import java.util.Stack;

public class StackRemoveExample {
    public static void main(String[] args) {
        var pilha = new Stack<Integer>();

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);

        // É possível remover o 2! Quebramos o invariante.
        pilha.remove(1);

        int tamanhoPilha = pilha.size();

        for (int i = 0; i < tamanhoPilha; i++) {
            System.out.println(pilha.pop());
        }
    }
}
