# Etapa 1: Construcción del proyecto
FROM maven:3.8.6-openjdk-17-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y los archivos de dependencias para aprovechar la caché de Docker
COPY pom.xml .
COPY src ./src

# Ejecuta la compilación del proyecto utilizando Maven
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen final
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/player-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que tu aplicación estará escuchando
EXPOSE 8080

# Define el comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
