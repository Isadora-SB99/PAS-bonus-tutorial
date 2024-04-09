package br.com.padarqsis.layerbasedapplic.message;

import br.com.padarqsis.layerbasedapplic.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_1_NAME)
    public void receiveFromQueue1(String message) {
        System.out.println("Recebido da Fila 1: " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_2_NAME)
    public void receiveFromQueue2(String message) {
        System.out.println("Recebido da Fila 2: " + message);
    }
}