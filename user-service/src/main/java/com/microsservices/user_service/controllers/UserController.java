package com.microsservices.user_service.controllers;

import com.microsservices.user_service.dto.UserDto;
import com.microsservices.user_service.models.User;
import com.microsservices.user_service.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuários", description = "Endpoints de usuários")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto dto) throws BadRequestException {
        var model = new User();
        BeanUtils.copyProperties(dto,model);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(model));
    }

    @GetMapping("/{id}")
    public Optional<User> findById (@PathVariable("id") UUID userId) {
        return service.findById(userId);
    }
}
