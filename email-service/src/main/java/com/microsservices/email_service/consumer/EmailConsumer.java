package com.microsservices.email_service.consumer;

import com.microsservices.email_service.dto.EmailDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenToEmailQueue(@Payload EmailDto dto) {
        System.out.println(dto.emailTo());
    }
}
