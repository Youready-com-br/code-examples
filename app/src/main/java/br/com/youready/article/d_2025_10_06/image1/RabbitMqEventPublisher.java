package br.com.youready.article.d_2025_10_06.image1;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("rabbitmq")
@AllArgsConstructor
public class RabbitMqEventPublisher implements EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(String topic, DomainEvent event) {
        rabbitTemplate.convertAndSend(topic, event);
    }
}
