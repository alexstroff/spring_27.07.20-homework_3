package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sample.dao.StudentRepository;
import ru.geekbrains.sample.dto.StudentDTO;

@Controller
//@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentRepository.findAllStudents());
        return "student";
    }

    @PostMapping
    public void sendForm(@RequestBody StudentDTO studentDTO) {
        studentRepository.save(studentDTO);
    }

}
