package com.hamsteronline.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO для регистрации нового пользователя
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {
    /**
     * Имя пользователя
     * (то, что отображается всем пользователям, кто просматривает данный аккаунт)
     */
    @NotBlank(message = "Имя пользователя обязательно")
    @Size(min = 3, max = 50, message = "Длина имени пользователя должна быть от 3 до 50 символов")
    @JsonProperty("username")
    @Description("Имя пользователя")
    private String username;

    /**
     * Тэг пользователя
     * (используется для поиска пользователя другими пользователями)
     */
    @NotBlank(message = "Тэг обязателен")
    @Size(min = 3, max = 50, message = "Длина тэга пользователя должна быть от 3 до 50 символов")
    @JsonProperty("tag")
    @Description("Тэг пользователя")
    private String tag;

    /**
     * Описание пользователя
     * (может написать о своих профессии, хобби или чём-то другом)
     */
    @Size(max = 200, message = "Максимальная длина описания пользователя - это 200 символов")
    @JsonProperty("description")
    @Description("Описание пользователя")
    private String description;

    /**
     * Электронная почта пользователя
     */
    @Email(message = "Некорректный формат email")
    @NotBlank(message = "Email обязателен")
    @Size(min = 5, max = 100, message = "Длина электронной почты должна быть от 5 до 100 символов")
    @JsonProperty("email")
    @Description("Электронная почта пользователя")
    private String email;

    /**
     * ID пола пользователя
     */
    @NotNull(message = "Пол пользователя является обязательным")
    @JsonProperty("sexId")
    @Description("Пол пользователя")
    private UUID sexId;

    /**
     * Пароль пользователя
     */
    @NotBlank(message = "Пароль обязателен")
    @Size(min = 8, message = "Длина пароля пользователя должна содержать минимум 8 символов")
    @JsonProperty("password")
    @Description("Пароль пользователя")
    private String password;
}
