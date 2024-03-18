
package com.todoapp.service.impl;

import com.todoapp.dao.UsuarioDao;
import com.todoapp.domain.Usuario;
import com.todoapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }
    
    @Override
    public Usuario getUsuarioByCorreoAndContrasena(String correo, String contrasena) {
        return usuarioDao.findByCorreoAndContrasena(correo, contrasena);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }
    
}
