package com.hamsteronline.backend.service;

import com.hamsteronline.backend.dto.request.UserCreateDTO;
import com.hamsteronline.backend.dto.request.UserUpdateDTO;
import com.hamsteronline.backend.dto.response.UserResponseDTO;
import com.hamsteronline.backend.entity.User;
import com.hamsteronline.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Сервис для реализации логики работы с пользователем
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * Создание нового пользователя
     */
    @Transactional
    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        log.info("Создание пользователя с email {}", userCreateDTO.getEmail());

        if (userRepository.existsByEmail(userCreateDTO.getEmail())) {
            // ToDo: Заменить на кастомное исключение EmailAlreadyExists
            throw new RuntimeException("Данная электронная почта уже занята!");
        }

        if (userRepository.existsByTag(userCreateDTO.getTag())) {
            // ToDo: Заменить на кастомное исключение TagAlreadyExists
            throw new RuntimeException("Данный тэг уже занят!");
        }

        User user = new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setTag(userCreateDTO.getTag());
        user.setDescription(userCreateDTO.getDescription());
        user.setEmail(userCreateDTO.getEmail());
        user.setSexId(userCreateDTO.getSexId());
        // ToDo: Добавить алгоритм хэширования (сейчас как заглушка)
        user.setPasswordHash(userCreateDTO.getPassword());

        User savedUser = userRepository.save(user);
        log.info("Создан пользователь с ID {}", savedUser.getId());

        return mapToResponseDTO(savedUser);
    }

    /**
     * Поулчение пользователя по ID
     */
    @Transactional(readOnly = true)
    public UserResponseDTO getUser(UUID id) {
        log.info("Получение пользователя с ID {}", id);

        // ToDo: Заменить на кастомное исключение UserNotFound
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь с ID " + id + " не найден"));

        return mapToResponseDTO(user);
    }

    /**
     * Обновление пользователя
     */
    @Transactional
    public UserResponseDTO updateUser(UUID id, UserUpdateDTO userUpdateDTO) {
        log.info("Обновление данных для пользователя с ID {}", id);

        // ToDo: Заменить на кастомное исключение UserNotFound
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь с ID " + id + " не найден"));

        if (userUpdateDTO.getUsername() != null) {
            user.setUsername(userUpdateDTO.getUsername());
        }

        if (userUpdateDTO.getTag() != null) {
            if (userRepository.existsByTag(userUpdateDTO.getTag())) {
                // ToDo: Заменить на кастомное исключение TagAlreadyExists
                throw new RuntimeException("Данный тэг уже занят");
            }

            user.setTag(userUpdateDTO.getTag());
        }

        if (userUpdateDTO.getDescription() != null) {
            user.setDescription(userUpdateDTO.getDescription());
        }

        if (userUpdateDTO.getSexId() != null) {
            user.setSexId(userUpdateDTO.getSexId());
        }

        User updatedUser = userRepository.save(user);
        return mapToResponseDTO(updatedUser);
    }

    /**
     * Удаление пользователя
     */
    @Transactional
    public void deleteUser(UUID id) {
        log.info("Удаление пользователя с ID {}", id);

        // ToDo: Заменить на кастомное исключение UserNotFound
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь с ID " + id + " не найден"));

        userRepository.delete(user);
    }

    /**
     * Маппинг сущности User на UserResponseDTO
     */
    private UserResponseDTO mapToResponseDTO(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setTag(user.getTag());
        response.setDescription(user.getDescription());
        response.setEmail(user.getEmail());
        response.setSexId(user.getSexId());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }
}
