package com.hamsteronline.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность пользователь
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "tag"),
        @UniqueConstraint(columnNames = "email")
})
public class UserDBO {
    /**
     * ID пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    /**
     * Имя пользователя
     * (то, что отображается всем пользователям, кто просматривает данный аккаунт)
     */
    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(min = 3, max = 50, message = "Длина имени пользователя должна быть от 3 до 50 символов")
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * Тэг пользователя
     * (используется для поиска пользователя другими пользователями)
     */
    @NotBlank(message = "Тэг пользователя не может быть пустым")
    @Size(min = 3, max = 50, message = "Длина тэга пользователя должна быть от 3 до 50 символов")
    @Column(name = "tag", nullable = false)
    private String tag;

    /**
     * Описание пользователя
     * (может написать о своих профессии, хобби или чём-то другом)
     */
    @Size(max = 200, message = "Максимальная длина описания пользователя - это 200 символов")
    @Column(name = "description", nullable = true)
    private String description;

    /**
     * Электронная почта пользователя
     */
    @NotBlank(message = "Электронная почта пользователя не может быть пустой")
    @Size(min = 5, max = 100, message = "Длина электронной почты должна быть от 5 до 100 символов")
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Фото профиля пользователя
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "profile_photo", nullable = true)
    private byte[] profilePhoto;

    /**
     * ID пола пользователя
     */
    @NotNull(message = "Пол пользователя является обязательным")
    @Column(name = "sex_id", nullable = false)
    private UUID sexId;

    /**
     * Хэш пароля пользователя
     */
    @NotBlank(message = "Хэш пароля пользователя не может быть пустым")
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    /**
     * Дата и время создания пользователя
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public UserDBO(UserDBO original) {
     this.id = original.getId();
     this.username = original.getUsername();
     this.tag = original.getTag();
     this.description = original.getDescription();
     this.email = original.getEmail();
     this.profilePhoto = original.getProfilePhoto();
     this.sexId = original.getSexId();
     this.passwordHash = original.getPasswordHash();
     this.createdAt = original.getCreatedAt();
    }
}
