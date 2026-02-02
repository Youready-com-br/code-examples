package br.com.youready.miniaulafev26.fast;

import br.com.youready.miniaulafev26.OrderItemRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderRequestFastImpl(
        @NotEmpty @Email String customerEmail,
        @NotEmpty @Valid List<OrderItemRequest> items,
        boolean isVip) {
}
