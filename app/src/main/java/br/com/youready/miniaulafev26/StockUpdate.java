package br.com.youready.miniaulafev26;

import java.io.Serializable;

public record StockUpdate(Long productId, Integer quantity) implements Serializable {}