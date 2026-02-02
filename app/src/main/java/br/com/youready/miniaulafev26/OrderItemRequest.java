package br.com.youready.miniaulafev26;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderItemRequest(
    @NotNull Long productId, @NotNull @Min(1) @Max(10) Integer quantity) {}
