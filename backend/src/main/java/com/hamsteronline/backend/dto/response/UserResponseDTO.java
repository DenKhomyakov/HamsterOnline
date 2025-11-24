package com.hamsteronline.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO для возвращения данных о пользователе в API
 * Содержит только "безопасные" для отображения поля
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    /**
     * ID пользователя
     */
    @JsonProperty("id")
    @Description("ID пользователя")
    private UUID id;

    /**
     * Имя пользователя
     * (то, что отображается всем пользователям, кто просматривает данный аккаунт)
     */
    @JsonProperty("username")
    @Description("Имя пользователя")
    private String username;

    /**
     * Тэг пользователя
     * (используется для поиска пользователя другими пользователями)
     */
    @JsonProperty("tag")
    @Description("Тэг пользователя")
    private String tag;

    /**
     * Описание пользователя
     * (может написать о своих профессии, хобби или чём-то другом)
     */
    @JsonProperty("description")
    @Description("Описание пользователя")
    private String description;

    /**
     * Электронная почта пользователя
     */
    @JsonProperty("email")
    @Description("Электронная почта пользователя")
    private String email;

    /**
     * ID пола пользователя
     */
    @JsonProperty("sexId")
    @Description("ID пола пользователя")
    private UUID sexId;

    /**
     * Дата и время создания пользователя
     */
    @JsonProperty("createdAt")
    @Description("Дата и время создания пользователя")
    private LocalDateTime createdAt;
}
