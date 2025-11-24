package com.hamsteronline.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO для обновления данных пользователя
 * Все поля опциональны (обновляются только переданные значения)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    /**
     * Имя пользователя
     * (то, что отображается всем пользователям, кто просматривает данный аккаунт)
     */
    @Size(min = 3, max = 50, message = "Длина имени пользователя должна быть от 3 до 50 символов")
    @JsonProperty("username")
    @Description("Имя пользователя")
    private String username;

    /**
     * Тэг пользователя
     * (используется для поиска пользователя другими пользователями)
     */
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
     * ID пола пользователя
     */
    @JsonProperty("sexId")
    @Description("ID пола пользователя")
    private UUID sexId;
}
