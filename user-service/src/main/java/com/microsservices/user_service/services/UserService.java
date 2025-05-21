package com.microsservices.user_service.services;

import com.microsservices.user_service.models.User;
import com.microsservices.user_service.producer.UserProducer;
import com.microsservices.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserProducer producer;

    public UserService(UserRepository repository, UserProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Transactional
    public User saveUser(User user) throws BadRequestException {
        try{
            if(user.getEmail() == null) {
                throw new BadRequestException("Email Vazio");
            }
            var saveModel = repository.save(user);
            producer.publishMessageEmail(user);
            return saveModel;
        }
        catch (Exception e) {
            throw e;
        }
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(UUID userId) {
        return Optional.ofNullable(repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário com ID " + userId + " não encontrado")));
    }

}
