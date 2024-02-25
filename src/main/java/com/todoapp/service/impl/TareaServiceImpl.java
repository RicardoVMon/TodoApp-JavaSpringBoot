package com.todoapp.service.impl;

import com.todoapp.dao.TareaDao;
import com.todoapp.domain.Tarea;
import com.todoapp.service.TareaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    TareaDao tareaDao;
    
    @Override
    public List<Tarea> getTareas() {
        List<Tarea> lista = tareaDao.findAll();
        lista.removeIf(t -> !t.isActiva());
        return lista;
    }
    
    @Override
    public List<Tarea> getTareasInactivas() {
        List<Tarea> lista = tareaDao.findAll();
        lista.removeIf(t -> t.isActiva());
        return lista;
    }

    @Override
    public void delete(Tarea tarea) {
        tareaDao.delete(tarea);
    }

    @Override
    public void save(Tarea tarea) {
        tareaDao.save(tarea);
    }

    @Override
    public Tarea getTarea(Tarea tarea) {
        return tareaDao.findById(tarea.getIdTarea()).orElse(null);
    }

    @Override
    public Tarea complete(Tarea tarea) {
        tarea.setActiva(false);
        return tarea;
    }

    @Override
    public Tarea uncomplete(Tarea tarea) {
        tarea.setActiva(true);
        return tarea;
    }

    
    
    

}
