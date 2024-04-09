package br.com.padarqsis.layerbasedapplic;

import br.com.padarqsis.layerbasedapplic.message.MessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LayerBasedApplicApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayerBasedApplicApplication.class, args);
    }

    @Bean
    CommandLineRunner demo1(MessageProducer messageProducer) {
        return args -> {
            messageProducer.sendMessageToQueue1("Olá da Fila 1!");
            messageProducer.sendMessageToQueue2("Saudações da Fila 2!");
        };
    }

}
