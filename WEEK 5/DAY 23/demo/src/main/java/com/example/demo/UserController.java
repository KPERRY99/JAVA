package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    final DatiFiglio figlio;
    //final DatiUtente utente;

    public UserController(DatiFiglio figlio){
        this.figlio = figlio;
    }

    @GetMapping("/DemoApplication")
    @ResponseBody
    public String DemoApplication() {
        // figlio.toString();
        // System.out.println("\n");
        // utente.toString();
        return figlio.toString();
    }

    
}