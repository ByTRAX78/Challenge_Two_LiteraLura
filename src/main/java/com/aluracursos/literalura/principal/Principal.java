package com.aluracursos.literalura.principal;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.DatosLibros;
import com.aluracursos.literalura.model.Libros;
import com.aluracursos.literalura.services.AutorService;
import com.aluracursos.literalura.services.ConsumoAPI;
import com.aluracursos.literalura.services.Conversor;
import com.aluracursos.literalura.services.LibrosService;

@Component
public class Principal {

    @Autowired
    private ConsumoAPI consumoApi;
    @Autowired
    private LibrosService librosService;
    @Autowired
    private AutorService autorService;
    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";


    public void mostrarMenu(){
        var opcion = -1;
        while (opcion != 0){
                var menu = """
                            Bienvenido a Literalura

                                1 - Agregar libros
                                2 - Buscar libros por título
                                3 - Buscar libros por autor
                                4 - Buscar libros por idioma
                                5 - Buscar autores vivos por año

                                0 - Salir

                                Elige una opción:
                                """;
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                        case 1:
                                buscarLibro();
                                break;
                        case 2:
                                buscarLibroPorTitulo();
                                break;
                        case 3:
                                buscarLibroPorAutor();
                                break;
                        case 4:
                                buscarLibroPorIdioma();
                                break;
                        case 5:
                                buscarAutoresVivosEnAno();
                                break;
                        case 0:
                                System.out.println("Cerrando la aplicación...");
                                break;
                        default:
                                System.out.println("Opción no válida");
                        }
                }
        }

    private void buscarLibro() {
        DatosLibros datos = getDatosLibros();
        Libros libro = new Libros(datos);
        librosService.guardarLibro(libro);
        System.out.println("Libro guardado: " + libro);
    }

    private DatosLibros getDatosLibros() {
        System.out.println("Escribe el id del libro a agregar: ");
        var idLibro = teclado.nextLine();
    
        var json = consumoApi.obtenerDatos(URL_BASE + idLibro.replace( " ","+") + "/");
    
        System.out.println("JSON recibido:");
        System.out.println(json);

        if (json == null || json.isEmpty()) {
            throw new RuntimeException("La respuesta de la API fue nula o vacía para el libro con ID: " + idLibro);
        }

        DatosLibros datos = Conversor.obtenerDatos(json, DatosLibros.class);

        if (datos == null) {
            throw new RuntimeException("No se pudieron convertir los datos del libro con ID: " + idLibro);
        }

        return datos;
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Escribe el título del libro que deseas buscar: ");
        var titulo = teclado.nextLine();

        List<Libros> librosEncontrados = librosService.buscarLibrosPorTitulo(titulo);

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.\n");
        } else {
            System.out.println("Libros encontrados:\n");
            for (Libros libro : librosEncontrados) {
                System.out.println(libro);
            }
        }
    }
    
    private void buscarLibroPorAutor() {
        System.out.println("Escribe el nombre del autor que deseas buscar: ");
        var nombreAutor = teclado.nextLine();

        List<Libros> libros = librosService.buscarPorAutor(nombreAutor);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros para el autor: " + nombreAutor + "\n");
        } else {
            System.out.println("Libros encontrados:");
            libros.forEach(System.out::println);
        }
    }

    private void buscarLibroPorIdioma() {
        System.out.println("Escribe el idioma del libro que deseas buscar: ");
        var idioma = teclado.nextLine();

        List<Libros> libros = librosService.buscarPorIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros para el idioma: " + idioma + "\n");
        } else {
            System.out.println("Libros encontrados:");
            libros.forEach(System.out::println);
        }
    }

    private void buscarAutoresVivosEnAno() {
        System.out.println("Escribe el año que deseas buscar: ");
        int anio = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autores = autorService.buscarAutoresVivosEnAno(anio);
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año: " + anio + "\n");
        } else {
            System.out.println("Autores encontrados:");
            autores.forEach(System.out::println);
        }
    }

}
