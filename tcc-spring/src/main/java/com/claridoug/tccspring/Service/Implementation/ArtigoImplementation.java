package com.claridoug.tccspring.Service.Implementation;

import com.claridoug.tccspring.DTO.ArtigoDTO;
import com.claridoug.tccspring.DTO.UsuarioDTO;
import com.claridoug.tccspring.Service.ArtigoService;
import com.claridoug.tccspring.model.entity.Artigo;
import com.claridoug.tccspring.model.entity.Usuario;
import com.claridoug.tccspring.repository.ArtigoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtigoImplementation implements ArtigoService {

    private ArtigoRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ArtigoImplementation(ArtigoRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    @Transactional
    public Artigo salvarArtigo(ArtigoDTO artigoDto) {
        Artigo artigo = modelMapper.map(artigoDto, Artigo.class);
        return repository.save(artigo);
    }


}
