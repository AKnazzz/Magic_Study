package org.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.app.entities.User;
import org.app.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "API управления пользователями")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    @Operation(summary = "Получить все книги")
    public List<User> getAll(){
        logger.info("Получение полного списка пользователей");
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить книгу по ID")
    public Optional<User> getById(@PathVariable("id")int id){
        logger.info("Получение пользователя по ID");
        return userRepository.findById(id);
    }
}
