package com.claridoug.tccspring.Service.Controller;

import Exceptions.RegraNegocioException;
import com.claridoug.tccspring.Service.UsuarioService;
import com.claridoug.tccspring.model.entity.Usuario;
import com.claridoug.tccspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioController implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
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
        boolean existe = repository.existsByEmail(email);
        if(existe) {
            throw new RegraNegocioException("Já existe um usuário com esse email!");
        }

    }
}
