# LiteraLura

## Resumen

**LiteraLura** es una aplicación de consola que permite realizar búsquedas de libros por título, autor o idioma, así como buscar autores vivos en un determinado año. Esta funcionalidad es posible gracias a la información obtenida de la API de Gutendex. El proyecto está desarrollado en Java y utiliza el framework Spring y JPA para la gestión de datos.

## Características

- **Búsqueda de libros**: Permite buscar libros por título, autor o idioma.
- **Búsqueda de autores vivos**: Permite buscar autores que estaban vivos en un año específico.
- **Integración con API Gutendex**: Obtiene información de libros y autores desde la API de Gutendex.
- **Gestión de datos**: Utiliza JPA para la persistencia de datos en una base de datos PostgreSQL.

## Tecnologías y Herramientas Utilizadas

- ☕ [Java](https://www.java.com/es/): Lenguaje de programación utilizado para desarrollar la aplicación.
- 🍃 [Spring Framework](https://spring.io/): Framework utilizado para la gestión de dependencias, creación de APIs REST y manejo de la lógica de negocio.
- 🐘 [PostgreSQL](https://www.postgresql.org/): Sistema de gestión de bases de datos relacional utilizado para almacenar la información.

## Requisitos Previos

Antes de empezar, asegúrate de tener instalados los siguientes componentes:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 21 o superior
- [PostgreSQL](https://www.postgresql.org/download/)
- [Visual Studio Code](https://code.visualstudio.com/) o tu IDE preferido
- [Maven](https://maven.apache.org/download.cgi) para la gestión de dependencias

## Configuración del Proyecto

1. **Clonar el repositorio**

   ```sh
   git clone https://github.com/tu_usuario/literalura.git
   cd literalura
   ```

2. **Configurar la base de datos**

   - Crear una base de datos en PostgreSQL.
   - Actualizar las credenciales de conexión en el archivo `application.properties` ubicado en `src/main/resources/`.

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Instalar dependencias**

   Ejecuta el siguiente comando para descargar e instalar las dependencias del proyecto:

   ```
   mvn clean install
   ```

## Ejecución de la Aplicación

Para ejecutar la aplicación, utiliza el siguiente comando:

```
mvn spring-boot:run
```

## Uso de la Aplicación

La aplicación se ejecuta en la consola y permite las siguientes operaciones:

- **Buscar libros por título**:
  ```
  Enter title to search: "El Quijote"
  ```

- **Buscar libros por autor**:
  ```
  Enter author to search: "Miguel de Cervantes"
  ```

- **Buscar libros por idioma**:
  ```
  Enter language to search: "es"  
  ```

- **Buscar autores vivos en un año específico**:
  ```
  Enter year to search for living authors: 1605
  ```

## Contribución

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva_caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva característica'`).
4. Sube tus cambios a tu repositorio (`git push origin feature/nueva_caracteristica`).
5. Crea un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para obtener más información.

## Contacto

Para cualquier consulta o sugerencia, puedes contactar al desarrollador:

- **Nombre**: Adrian Martinez Martinez
- **Correo**: martinezmartinezaadrian@gmail.com
- **GitHub**: [ByTRAX78](https://github.com/ByTRAX78)
