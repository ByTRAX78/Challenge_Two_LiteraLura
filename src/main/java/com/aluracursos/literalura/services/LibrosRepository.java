package com.aluracursos.literalura.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aluracursos.literalura.model.Libros;

public interface LibrosRepository extends JpaRepository<Libros, Integer> {
    List<Libros> findByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT l FROM Libros l JOIN l.autor a WHERE UPPER(a.nombre) LIKE UPPER(CONCAT('%', :nombre, '%')) OR UPPER(a.nombre) LIKE UPPER(CONCAT('%', :apellido, '%'))")
    List<Libros> findByAutorNombreOrApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);

    @Query("SELECT l FROM Libros l JOIN l.idiomas i WHERE UPPER(i) = UPPER(:idioma)")
    List<Libros> findByIdioma(@Param("idioma") String idioma);
}
