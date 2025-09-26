package br.com.youready.article.d_2025_03_10.image1

import java.util.concurrent.Executors

class SleepSort {
    static void sort(List<Integer> unsorted) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            unsorted.each { number ->
                executor.submit() -> {
                    Thread.sleep(number * 100)
                    println(number)
                }
            }
        }
    }
}
