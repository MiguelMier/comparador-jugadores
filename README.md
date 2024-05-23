# Comparador de Jugadores

## Descripción

Este proyecto es una aplicación backend desarrollada en Java usando Spring Boot. La finalidad del proyecto es proporcionar una API REST que permita a los usuarios comparar las estadísticas de diferentes jugadores de fútbol. La información de los jugadores se obtiene de una API externa proporcionada por RapidAPI. Los datos se almacenan y gestionan en una base de datos MariaDB. Además, la aplicación está dockerizada para facilitar su despliegue y gestión.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo del backend.
- **MariaDB**: Sistema de gestión de bases de datos relacional.
- **Docker**: Plataforma de contenedorización para simplificar el despliegue y la ejecución de la aplicación.
- **RapidAPI**: Fuente externa para obtener datos de jugadores de fútbol.
- **JPA (Java Persistence API)**: Para la gestión de la persistencia de datos.
- **RestTemplate**: Para realizar llamadas HTTP a la API de RapidAPI.

## Funcionalidades

- **Obtener Información de Jugadores**: Recupera información detallada de jugadores de fútbol desde RapidAPI.
- **Comparar Jugadores**: Compara estadísticas de dos jugadores, incluyendo goles, asistencias y partidos jugados.
- **Persistencia de Datos**: Almacena y gestiona datos de jugadores en una base de datos MariaDB.

## Dockerización

Para la realización del Dockerfile y demás, se han utilizado los siguientes comandos:

- **Dockerfile**: se crea el archivo Dockerfile y se añade el contenido relevante de directorio y el archivo JAR.
  - **JAR**: para crear el archivo JAR se necesita ejecutar previamente: ``` mvn clean package ```
- **Construir la imagen**: Una vez creado el JAR y el Dockerfile, se crea la imagen: ```docker build -t player:latest .```
- **Ejecutar el contenedor**: Una vez creada la imagen, se ejecuta: ```docker run -p 8080:8080 player:latest```