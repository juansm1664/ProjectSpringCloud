FROM openjdk:17.0.2

WORKDIR /app

COPY ./target/msvc-usuario-0.0.1-SNAPSHOT.jar .

EXPOSE 8801


LABEL authors="juandavid"

ENTRYPOINT ["java", "-jar", "msvc-usuario-0.0.1-SNAPSHOT.jar"]