
package com.todoapp.dao;

import com.todoapp.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findByCorreoAndContrasena(String correo, String contrasena);
    
}
