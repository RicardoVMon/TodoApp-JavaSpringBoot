
package com.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AutenticacionController {
    
    @GetMapping("/")
    public String login(Model model) {
        return "/autenticacion/login";
    }
    
    @GetMapping("/registro")
    public String registro(Model model) {
        return "/autenticacion/registro";
    }
    
}
