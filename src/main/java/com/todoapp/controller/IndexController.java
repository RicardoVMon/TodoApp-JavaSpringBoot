package com.todoapp.controller;

import com.todoapp.domain.Tarea;
import com.todoapp.domain.Usuario;
import com.todoapp.service.TareaService;
import com.todoapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    
    @Autowired
    TareaService tareaService;
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public String page(Model model, Usuario usuario) {
        
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("idUsuario", usuario.getIdUsuario());
        
        List<Tarea> listaActivas = tareaService.getTareas(usuario);
        model.addAttribute("tareasActivas", listaActivas);
        
        List<Tarea> listaInactivas = tareaService.getTareasInactivas(usuario);
        model.addAttribute("tareasInactivas", listaInactivas);
        
        return "index";
    }

    
    
}
