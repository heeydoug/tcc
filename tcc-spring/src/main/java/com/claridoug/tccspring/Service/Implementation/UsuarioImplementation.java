package com.claridoug.tccspring.Service.Implementation;

import com.claridoug.tccspring.Exceptions.ErroAutenticacao;
import com.claridoug.tccspring.Exceptions.RegraNegocioException;
import com.claridoug.tccspring.Service.UsuarioService;
import com.claridoug.tccspring.model.entity.Usuario;
import com.claridoug.tccspring.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioImplementation implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioImplementation(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    @Transactional
    public Usuario autenticar(String email, String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);
        if(!usuario.isPresent()) {
            throw new ErroAutenticacao("Não existe usuário para esse email!");
        }
        if(!usuario.get().getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha Inválida!");
        }
        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe) {
            throw new RegraNegocioException("Já existe um usuário com esse email!");
        }

    }
}
