package com.hamsteronline.backend.controller;

import com.hamsteronline.backend.dto.request.UserCreateDTO;
import com.hamsteronline.backend.dto.request.UserUpdateDTO;
import com.hamsteronline.backend.dto.response.UserResponseDTO;
import com.hamsteronline.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Контроллер для работы с пользователем
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Создание нового пользователя
     */
    // ToDo: Добавить аннотации @Operation и @ApiResponse
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

    /**
     * Получение пользователя по ID
     */
    // ToDo: Добавить аннотации @Operation и @ApiResponse
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    /**
     * Обновление пользователя
     */
    // ToDo: Добавить аннотации @Operation и @ApiResponse
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody UserUpdateDTO userUpdateDTO
            ) {
        return userService.updateUser(id, userUpdateDTO);
    }

    /**
     * Удаление пользователя
     */
    // ToDo: Добавить аннотации @Operation и @ApiResponse
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
