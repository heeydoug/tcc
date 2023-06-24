package com.claridoug.tccspring.Controller;

import com.claridoug.tccspring.DTO.UsuarioDTO;
import com.claridoug.tccspring.Exceptions.RegraNegocioException;
import com.claridoug.tccspring.Service.UsuarioService;
import com.claridoug.tccspring.model.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Controller/Usuario")
public class UsuarioController {

    private UsuarioService service;

    private UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO dto){
        Usuario usuario =  Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()).build();

        try {
            Usuario usuarioSalvo = service.salvarUsuario(usuario);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
        }catch(RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        }


}
