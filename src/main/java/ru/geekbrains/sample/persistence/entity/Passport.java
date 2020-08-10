package ru.geekbrains.sample.persistence.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Passport extends AbstractEntity {
    private String name;
}