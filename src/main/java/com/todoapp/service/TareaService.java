package com.todoapp.service;

import com.todoapp.domain.Tarea;
import com.todoapp.domain.Usuario;
import java.util.List;

public interface TareaService {
    
    public List<Tarea> getTareas(Usuario usuario);
    
    public List<Tarea> getTareasInactivas(Usuario usuario);
    
    public Tarea getTarea(Tarea tarea);
    
    public Tarea getTareaById(Long id);
    
    public void delete(Tarea tarea);
    
    public void save(Tarea tarea);
    
    public Tarea complete(Tarea tarea);
    
    public Tarea uncomplete(Tarea tarea);

}
