package ru.geekbrains.sample.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)public class Tutor extends AbstractEntity {

    private String name;

    private String surname;

    @Column(name = "is_working")
    private boolean isWorking;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_tutor", joinColumns = @JoinColumn(name = "tutor_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Tutor> tutors;
}
