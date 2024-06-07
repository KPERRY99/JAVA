package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("/showPerson")
    public String showPerson(Model model) {
        Person person = new Person();
        person.setName("Armando");
        person.setAge(30);

        model.addAttribute("person", person);
        return "person";
    }
}
