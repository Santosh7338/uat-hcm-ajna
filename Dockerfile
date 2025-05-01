# Use a base image that contains Java
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Add the Lombok fix by setting compiler options
ENV MAVEN_OPTS="--add-opens jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED"

COPY src ./src


# Copy the JAR file from the host into the container at /app
COPY target/ajan-hcm-0.0.1-SNAPSHOT.jar /app/ajan-hcm-0.0.1-SNAPSHOT.jar

# Expose any necessary ports for your application
# EXPOSE 8080

# Command to run your application when the container starts
CMD ["java", "-jar", "ajan-hcm-0.0.1-SNAPSHOT.jar"]
