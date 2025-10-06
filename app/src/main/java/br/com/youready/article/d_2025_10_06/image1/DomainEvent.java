package br.com.youready.article.d_2025_10_06.image1;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public abstract class DomainEvent {

    private final UUID id;
    private final LocalDateTime creationDate;

    public DomainEvent() {
        this.id = UUID.randomUUID();
        this.creationDate = LocalDateTime.now();
    }
}
