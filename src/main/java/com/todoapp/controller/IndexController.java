package com.todoapp.controller;

import com.todoapp.domain.Tarea;
import com.todoapp.service.TareaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    
    @Autowired
    TareaService tareaService;

    @GetMapping("/")
    public String page(Model model) {
        List<Tarea> listaActivas = tareaService.getTareas();
        List<Tarea> listaInactivas = tareaService.getTareasInactivas();
        model.addAttribute("tareasActivas", listaActivas);
        model.addAttribute("tareasInactivas", listaInactivas);
        return "index";
    }

    @GetMapping("/delete/{idTarea}")
    public String page(Tarea tarea) {
        tareaService.delete(tarea);
        return "redirect:/";
    }

    @GetMapping("/crear")
    public String page() {
        return "/tareas/crear";
    }

    @PostMapping("/crear")
    public String tareaCreate(Tarea tarea) {
        tareaService.save(tarea);
        return "redirect:/";
    }
    
    @GetMapping("/actualizar/")
    public String pageActualizar(Tarea tarea, Model model) {
        return "/tareas/actualizar";
    }
    
    @GetMapping("/actualizar/{idTarea}")
    public String page(Tarea tarea, Model model) {
        tarea = tareaService.getTarea(tarea);
        model.addAttribute("tarea", tarea);
        return "/tareas/actualizar";
    }
    
    @GetMapping("/completar/{idTarea}")
    public String pageCompletar(Tarea tarea) {
        tareaService.save(tareaService.complete(tareaService.getTarea(tarea)));
        return "redirect:/";
    }
    
    @GetMapping("/decompletar/{idTarea}")
    public String pageDecompletar(Tarea tarea) {
        tareaService.save(tareaService.uncomplete(tareaService.getTarea(tarea)));
        return "redirect:/";
    }
    
}
