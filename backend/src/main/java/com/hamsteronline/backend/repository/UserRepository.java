package com.hamsteronline.backend.repository;

import com.hamsteronline.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий для работы с пользователями
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    /**
     * Найти пользователя по тэгу
     */
    Optional<User> findByTag(String tag);

    /**
     * Найти пользователя по электронной почте
     */
    Optional<User> findByEmail(String email);

    /**
     * Проверить существование пользователя по тэгу
     */
    boolean existsByTag(String tag);

    /**
     * Проверить существование пользователся по электронной почте
     */
    boolean existsByEmail(String email);

    /**
     * Найти пользователя по электронной почте или тэгу
     * (используется для авторизации)
     */
    @Query("SELECT u FROM User u WHERE u.email = :identifier OR u.tag = :identifier")
    Optional<User> findByEmailOrTag(@Param("identifier") String identifier);
}
