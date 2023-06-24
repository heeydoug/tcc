package com.claridoug.tccspring.Service;

import com.claridoug.tccspring.model.entity.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);

}
