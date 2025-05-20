package com.microsservices.user_service.services;

import com.microsservices.user_service.models.User;
import com.microsservices.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) throws BadRequestException {
        try{
            if(user.getEmail() == null) {
                throw new BadRequestException("Email Vazio");
            }
            return repository.save(user);
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
