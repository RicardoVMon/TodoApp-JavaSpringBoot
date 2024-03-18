package com.todoapp.controller;

import com.todoapp.domain.Usuario;
import com.todoapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/crear")
    public String crear(Model model, Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/" + usuario.getIdUsuario();
    }

    @PostMapping("/validar")
    public String validar(@RequestParam("correo") String correo,
            @RequestParam("contrasena") String contrasena, Model model) {
        Usuario usuario = usuarioService.getUsuarioByCorreoAndContrasena(correo, contrasena);
        if (usuario != null) {
            return "redirect:/" + usuario.getIdUsuario();
        } else {
            return "redirect:/";
        }

    }

}
