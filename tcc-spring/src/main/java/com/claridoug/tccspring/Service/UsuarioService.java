package com.claridoug.tccspring.Service;

import com.claridoug.tccspring.DTO.UsuarioDTO;
import com.claridoug.tccspring.model.entity.Usuario;
import org.modelmapper.ModelMapper;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);

    Usuario salvarUsuario(UsuarioDTO usuario);

    void validarEmail(String email);

}
