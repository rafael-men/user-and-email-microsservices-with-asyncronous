# 🚀 Comunicação Assíncrona com Microsserviços e RabbitMQ

Sistema de comunicação assíncrona entre microsserviços Java usando RabbitMQ como broker de mensagens. Este projeto demonstra como diferentes serviços podem se comunicar de forma desacoplada através da troca de mensagens via filas.

## 📌 Visão Geral

Este projeto é composto por dois microsserviços desenvolvidos em Java e Spring Boot, para registro de usuários e envio de mensagens por email, integrados por meio do RabbitMQ, permitindo uma arquitetura escalável e resiliente.
A comunicação entre os serviços ocorre de forma assíncrona, onde o serviço de criação e gestão de usuários publica eventos/mensagens em filas específicas, direcionados ao serviço de envio de emails, havendo também um broker para servir de comunicador entre os serviços.

<div style="text-align: center;">
  <img 
    src="https://github.com/user-attachments/assets/b08004cf-7ec9-4f0c-88c6-b57aa4dd7993" 
    alt="Captura de tela" 
    style="max-width: 100%; height: auto; display: block; margin: 0 auto;"
  >
</div>

## 🔧 Tecnologias Utilizadas
- Java.
- RabbitMQ.
- Docker.
- Docker Compose.
- Spring Framework.
- Banco de Dados PostgreSQL.
  
<hr/>

## 🚀 Como Executar

### Pré-requisitos:
- Docker
- Docker Compose

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/nome-do-projeto.git 
```

2. Suba os containers com Docker Compose:

```bash
cd user-and-email-microsservices-with-asyncronous
docker-compose up
```
Isso iniciará o RabbitMQ e os microsserviços. 

Acesse os serviços:
User : [http://localhost:8079/swagger-ui.](http://localhost:8079/swagger-ui/index.html)
Email : [http://localhost:8080](http://localhost:8080/swagger-ui/index.html)

## 🤝 Contribuição
- Contribuições são bem-vindas! Se você quiser melhorar esse projeto, corrigir bugs ou adicionar novas funcionalidades, fique à vontade!

- Faça um fork do repositório.
- Crie uma nova branch (git checkout -b feature/nova-feature).
- Commit suas mudanças (git commit -m 'feat: nova feature').
- Push para a branch (git push origin feature/nova-feature).
- Abra um Pull Request.
