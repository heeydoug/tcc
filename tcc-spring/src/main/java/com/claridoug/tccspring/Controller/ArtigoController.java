package com.claridoug.tccspring.Controller;

import com.claridoug.tccspring.DTO.ArtigoDTO;
import com.claridoug.tccspring.Service.ArtigoService;
import com.claridoug.tccspring.model.entity.Artigo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Controller/Artigo")
public class ArtigoController {

    private ArtigoService service;
    private ArtigoController(ArtigoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ArtigoDTO dto){
        Artigo artigoSalvo = service.salvarArtigo(dto);
        return new ResponseEntity(artigoSalvo, HttpStatus.CREATED);
    }

}
