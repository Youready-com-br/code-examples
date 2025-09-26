package br.com.youready.article.d_2025_03_10.image1;

import java.util.concurrent.Executors;

var unsorted = [3, 5, 2, 1, 4]

try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    unsorted.each { number ->
        executor.submit() {
            Thread.sleep(number * 100)
            println(number)
        }
    }
}