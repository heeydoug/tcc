package com.claridoug.tccspring.Service.Controller;

import com.claridoug.tccspring.Service.UsuarioService;
import com.claridoug.tccspring.model.entity.Usuario;
import com.claridoug.tccspring.repository.UsuarioRepository;

public class UsuarioController implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {

    }
}
