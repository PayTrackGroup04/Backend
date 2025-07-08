FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests -X

RUN ls -la /app/target

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/spring-boot-starter-parent-0.0.1-SNAPSHOT.jar /app/spring-boot-starter-parent.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/spring-boot-starter-parent.jar"]