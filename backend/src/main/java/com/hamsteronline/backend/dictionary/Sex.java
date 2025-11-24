package com.hamsteronline.backend.dictionary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Справочник полов пользователя
 * MALE - Мужской
 * FEMALE - Женский
 * */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "sex")
public class Sex {
    /**
     * ID пола пользователя
     * Используется для связи с другими сущностями
     * Соответствует константам из вложенного класса Constants
     */
    @Id
    @Column(name = "id")
    private UUID id;

    /**
     * Наименование пола пользователя
     * (на русском языке)
     */
    @Column(name = "name", nullable = false)
    private String name;

 public static class Constants {
     /**
      * Мужской пол
      */
     public final static UUID MALE = UUID.fromString("66a8344a-6aea-4482-b897-579d0d5f8cf7");

     /**
      * Женский пол
      */
     public final static UUID FEMALE = UUID.fromString("d54adb03-6814-4d28-8938-fce5729df760");
 }
}
