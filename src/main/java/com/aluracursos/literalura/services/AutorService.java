package com.aluracursos.literalura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluracursos.literalura.model.Autor;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> buscarAutoresVivosEnAno(int anio) {
        return autorRepository.findAutoresVivosEnAno(anio);
    }
}
