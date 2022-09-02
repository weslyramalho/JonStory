package com.wr.pedidosapi.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    private String pedidoExchange = "pedido-exchange";
    private String pedidoCriadoQueue = "pedido-criado";
    private String pedidoCriadoRoutingKey = "pedido-routing-key";

    @Bean
    public TopicExchange pedidoExchange() {
        return new TopicExchange(this.pedidoExchange);
    }

    @Bean
    public Queue pedidoCriadoQueue() {
        return new Queue(this.pedidoCriadoQueue);
    }

    @Bean
    public Binding orderBinding() {
        return BindingBuilder
                .bind(pedidoCriadoQueue())
                .to(pedidoExchange())
                .with(this.pedidoCriadoRoutingKey);
    }

    public String getPedidoExchange() {
        return pedidoExchange;
    }

    public String getPedidoCriadoQueue() {
        return pedidoCriadoQueue;
    }

    public String getPedidoCriadoRoutingKey() {
        return pedidoCriadoRoutingKey;
    }
}
