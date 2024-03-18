
package com.todoapp.controller;

import com.todoapp.domain.Tarea;
import com.todoapp.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TareaController {
    
    @Autowired
    TareaService tareaService;
    
    @GetMapping("/delete/{idUsuario}/{idTarea}")
    public String page(@PathVariable("idUsuario") int idUsuario, Tarea tarea) {
        tareaService.delete(tarea);
        return "redirect:/"+ idUsuario;
    }

    @GetMapping("/crear/{idUsuario}")
    public String page(@PathVariable("idUsuario") int idUsuario, Model model) {
        model.addAttribute("idUsuario", idUsuario);
        return "/tareas/crear";
    }

    @PostMapping("/crear/{idUsuario}")
    public String tareaCreate(@PathVariable("idUsuario") int idUsuario, Tarea tarea) {
        tareaService.save(tarea);
        return "redirect:/" + idUsuario;
    }
    
    @GetMapping("/actualizar/{idUsuario}/{idTarea}")
    public String pageActualizar(@PathVariable("idUsuario") int idUsuario, @PathVariable("idTarea") Long idTarea, Model model) {
        model.addAttribute("tarea", tareaService.getTareaById(idTarea));
        model.addAttribute("idUsuario", idUsuario);
        return "/tareas/actualizar";
    }
    
    @GetMapping("/completar/{idUsuario}/{idTarea}")
    public String pageCompletar(@PathVariable("idUsuario") int idUsuario, Tarea tarea) {
        tareaService.save(tareaService.complete(tareaService.getTarea(tarea)));
        return "redirect:/" + idUsuario;
    }
    
    @GetMapping("/decompletar/{idUsuario}/{idTarea}")
    public String pageDecompletar(@PathVariable("idUsuario") int idUsuario, Tarea tarea) {
        tareaService.save(tareaService.uncomplete(tareaService.getTarea(tarea)));
        return "redirect:/" + idUsuario;
    }
    
}
