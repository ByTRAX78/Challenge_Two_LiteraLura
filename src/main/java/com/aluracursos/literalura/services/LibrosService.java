package com.aluracursos.literalura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluracursos.literalura.model.Libros;

import org.springframework.transaction.annotation.Transactional;

@Service
public class LibrosService {
    @Autowired
    private LibrosRepository librosRepository;

    public void guardarLibro(Libros libro) {
        librosRepository.save(libro);
    }

    @Transactional(readOnly = true)
    public List<Libros> buscarLibrosPorTitulo(String titulo) {
        List<Libros> libros = librosRepository.findByTituloContainingIgnoreCase(titulo);
        for (Libros libro : libros) {
            libro.getAutor().size();
        }
        return libros;
    }

    public List<Libros> buscarPorAutor(String nombreCompleto) {
        String[] partes = nombreCompleto.split("\\s+");
        String nombre = partes[0];
        String apellido = partes.length > 1 ? partes[1] : "";
        return librosRepository.findByAutorNombreOrApellido(nombre, apellido);
    }

    public List<Libros> buscarPorIdioma(String idioma) {
        return librosRepository.findByIdioma(idioma);
    }
}
