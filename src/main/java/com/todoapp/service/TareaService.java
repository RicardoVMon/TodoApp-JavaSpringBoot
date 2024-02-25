package com.todoapp.service;

import com.todoapp.domain.Tarea;
import java.util.List;

public interface TareaService {
    
    public List<Tarea> getTareas();
    
    public List<Tarea> getTareasInactivas();
    
    public Tarea getTarea(Tarea tarea);
    
    public void delete(Tarea tarea);
    
    public void save(Tarea tarea);
    
    public Tarea complete(Tarea tarea);
    
    public Tarea uncomplete(Tarea tarea);

}
