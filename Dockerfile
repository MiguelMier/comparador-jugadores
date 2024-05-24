# Usa una imagen base de Java
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR del proyecto al contenedor
COPY target/player-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que tu aplicación estará escuchando
EXPOSE 8080

# Define el comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
