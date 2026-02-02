package br.com.youready.miniaulafev26.wellthought;

import br.com.youready.miniaulafev26.OrderItemRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderRequestWellThought(
        @NotEmpty @Email String customerEmail,
        @NotEmpty @Valid List<OrderItemRequest> items,
        Boolean isVip) {
}
