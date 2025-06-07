FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
CMD ["sh", "-c", "java -jar app.jar"]