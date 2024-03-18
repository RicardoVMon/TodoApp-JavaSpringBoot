
package com.todoapp.service;

import com.todoapp.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario usuario);
    
    public Usuario getUsuarioByCorreoAndContrasena(String correo, String contrasena);
    
    public void save(Usuario usuario);
    
}
