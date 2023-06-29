package com.claridoug.tccspring.Controller;

import com.claridoug.tccspring.DTO.UsuarioDTO;
import com.claridoug.tccspring.Exceptions.ErroAutenticacao;
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

        try {
            Usuario usuarioSalvo = service.salvarUsuario(dto);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
        }catch(RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO dto){
        try{
           Usuario usuarioAutenticado =  service.autenticar(dto.getEmail(), dto.getSenha());
           return ResponseEntity.ok(usuarioAutenticado);
        }catch(ErroAutenticacao erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }


    }
}
