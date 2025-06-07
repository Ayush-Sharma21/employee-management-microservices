# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy the JAR file to container
COPY target/*.jar app.jar

# Let Render set the port; EXPOSE is optional here
# EXPOSE 8080  # Optional: for documentation purposes

# Start app using dynamic port
CMD ["sh", "-c", "java -jar app.jar"]
