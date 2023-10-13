# Pais-Service - Ejemplo de Microservicio con Spring Boot

Pais-Service es un microservicio de ejemplo desarrollado con Spring Boot. Proporciona una API REST para gestionar información sobre países, incluyendo operaciones básicas como crear, leer, actualizar y eliminar países en una base de datos.

Este servicio es parte de un conjunto de microservicios destinados a ilustrar cómo desarrollar aplicaciones empresariales distribuidas utilizando la arquitectura de microservicios y las mejores prácticas de Spring Boot.

## Características Principales

- **Operaciones CRUD:** El servicio admite las operaciones básicas de Crear, Leer, Actualizar y Eliminar (CRUD) para entidades de país.
- **API RESTful:** Se expone como una API RESTful que permite interactuar con el servicio a través de HTTP.
- **Base de Datos:** Utiliza una base de datos PostgreSQL para almacenar la información de los países.
- **Documentación:** La API está documentada usando la especificación OpenAPI (anteriormente conocida como Swagger) para facilitar su uso y comprensión.

## Requisitos

- [OpenJDK 17](https://adoptium.net/) - El kit de desarrollo Java.
- [Apache Maven](https://maven.apache.org/download.cgi) - Para construir y gestionar el proyecto.
- [PostgreSQL](https://www.postgresql.org/download/) - La base de datos se usa para almacenar información de los países.

## Configuración

Asegúrate de tener un servidor PostgreSQL en ejecución y ajusta la configuración de la base de datos en el archivo `application.properties` antes de ejecutar el servicio. Modifica las propiedades `spring.datasource.url`, `spring.datasource.username` y `spring.datasource.password` según tus necesidades.

## Ejecución

Para compilar y ejecutar el servicio, sigue estos pasos:

1. Clona este repositorio o descarga el código fuente.
2. Abre una terminal y navega hasta el directorio del proyecto.
3. Ejecuta el siguiente comando para compilar el proyecto:
   ```mvn clean install```
4. Una vez que la compilación haya terminado con éxito, ejecuta el servicio:
   ```java -jar target/pais-service-1.0.0.jar```

El servicio estará en funcionamiento en `http://localhost:8081`.

## Documentación de la API

La documentación de la API está disponible en `http://localhost:8081/swagger-ui.html` una vez que el servicio esté en funcionamiento. Puedes utilizar esta documentación para probar las operaciones de la API y comprender cómo interactuar con el servicio.

## Contribuciones

Si deseas contribuir o mejorar este servicio de ejemplo, siéntete libre de hacerlo. Cualquier contribución es bienvenida. Solo asegúrate de seguir las mejores prácticas y mantener un código limpio y bien documentado.

## Licencia

Este proyecto se distribuye bajo la licencia MIT. Puedes ver los detalles en el archivo `LICENSE`.

---



