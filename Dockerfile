FROM maven:3.9.9 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests

FROM eclipse-temurin:21-alpine

VOLUME /tmp

EXPOSE 8080

COPY --from=builder /app/target/air-quality-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]