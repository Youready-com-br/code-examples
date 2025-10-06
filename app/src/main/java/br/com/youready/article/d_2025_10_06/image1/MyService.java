package br.com.youready.article.d_2025_10_06.image1;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final EventPublisher eventPublisher;

    public MyService(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void doSomething() {
        // ... some business logic
        eventPublisher.publish("some-topic", new MyDomainEvent());
    }

    private static class MyDomainEvent extends DomainEvent {}
}
