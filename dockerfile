# Dockerfile demo-rest-api
FROM eclipse-temurin:17.0.4.1_1-jdk-focal
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]