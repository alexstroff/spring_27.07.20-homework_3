package ru.geekbrains.sample.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends AbstractEntity {

    private String name;

    private Date birthDate;

    private boolean graduated;

    @Column(name = "last_name")
    private String surname;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student"), inverseJoinColumns = @JoinColumn(name = "subject"))
    private List<Subject> subjects;

    @OneToOne
    @JoinColumn(name = "passport")
    private Passport passport;

}