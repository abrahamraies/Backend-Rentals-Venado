FROM amazoncorretto:17-alpine-jdk
LABEL org.opencontainers.image.authors="AR"
COPY target/RentalsVenado-0.0.1-SNAPSHOT.jar ar-app.jar
ENTRYPOINT ["java","-jar","/ar-app.jar"]