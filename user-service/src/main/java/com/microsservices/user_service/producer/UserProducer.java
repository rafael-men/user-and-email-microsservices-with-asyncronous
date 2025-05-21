package com.microsservices.user_service.producer;

import com.microsservices.user_service.dto.EmailDto;
import com.microsservices.user_service.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;


    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    // Enviar email para o broker (publica mensagens na fila).
    public void publishMessageEmail(User user) {
        var emailDto = new EmailDto();
        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro Realizado.");
        emailDto.setText(user.getName() + "Seja Bem Vindo.");
        rabbitTemplate.convertAndSend("",routingKey,emailDto);
    }
}