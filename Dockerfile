FROM maven:3.9.6-eclipse-temurin-21-jammy

ENV TZ=Europe/Berlin

WORKDIR /app

COPY ./target/quiz-me-backend-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "quiz-me-backend-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080