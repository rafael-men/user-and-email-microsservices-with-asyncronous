# 🚀 Comunicação Assíncrona com Microsserviços e RabbitMQ

Sistema de comunicação assíncrona entre microsserviços Java usando RabbitMQ como broker de mensagens. Este projeto demonstra como diferentes serviços podem se comunicar de forma desacoplada através da troca de mensagens via filas.

## 📌 Visão Geral

Este projeto é composto por dois microsserviços desenvolvidos em Java e Spring Boot, para registro de usuários e envio de mensagens por email, integrados por meio do RabbitMQ, permitindo uma arquitetura escalável e resiliente.
A comunicação entre os serviços ocorre de forma assíncrona, onde o serviço de criação e gestão de usuários publica eventos/mensagens em filas específicas, direcionados ao serviço de envio de emails, garantindo baixo acoplamento e maior disponibilidade.

![Captura de tela 2025-05-20 165552](https://github.com/user-attachments/assets/a7a5c557-1f88-42ca-9f09-70b6c80b23a6)
