# Use a base image that includes Java
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from your local system into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot app will run on
EXPOSE 9095

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
