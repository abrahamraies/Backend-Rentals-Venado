FROM amazoncorretto:17-alpine-jdk
LABEL org.opencontainers.image.authors="AR"
COPY target/proyecto_alquiler_vehiculos-0.0.1-SNAPSHOT ar-app.jar
ENTRYPOINT ["java","-jar","/ar-app.jar"]