package br.com.youready.article.d_2025_03_10.image5

import groovy.lang.Closure

class CodeBlocksAsObjects {

    static void main(String[] args) {
        // Blocos de código em variáveis
        def helloWorldCodeBlock = { String name -> "Hello World, $name!"}
        def happyBirthdayCodeBlock = { String name -> "Happy Birthday, $name"}

        // Passando blocos de código como parâmetro
        printMessageFor('Issao', helloWorldCodeBlock)
        printMessageFor('Issao', happyBirthdayCodeBlock)

        // É possível passar um bloco de código direto como parâmetro
        printMessageFor('Issao', { String name -> "Hello, $name" })

        // É o mesmo código acima, mas em groovy, quando o último parâmetro é uma função,
        // podemos deixar o bloco de código fora do parênteses.
        printMessageFor('Issao') { String name -> "Hello, $name" }

        // Se o bloco de código só tem um parâmetro, tem uma variável especial
        // chamada "it" que possui o valor do parâmetro
        printMessageFor('Issao') { 'Hello, $it' }
    }

    static def printMessageFor(String name, Closure messageFunction) {
        // Utilizando o código!
        println messageFunction(name)
    }
}
