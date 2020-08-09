package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sample.dao.PhoneService;
import ru.geekbrains.sample.persistence.entity.Phone;

//@RestController
@Controller
@RequestMapping("/phones")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping
    public void saveOne(@RequestBody Phone phoneDTO) {
        phoneService.save(phoneDTO);
    }

    @GetMapping
    public String getPhonePage(Model model) {
        model.addAttribute("phones", phoneService.findAllPhones1());
        model.addAttribute("phonemin", phoneService.findPhoneByMinPrice());
        model.addAttribute("phonemax", phoneService.findPhoneByMaxPrice());
        model.addAttribute("phoneminandmax", phoneService.findPhoneByMaxAndMinPrice());
        return "phone";
    }
}
