# Use a base image that contains Java
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host into the container at /app
COPY target/ajan-hcm-0.0.1-SNAPSHOT.jar /app/ajan-hcm-0.0.1-SNAPSHOT.jar

# Expose any necessary ports for your application
# EXPOSE 8080

# Command to run your application when the container starts
#CMD ["java", "-jar", "ajan-hcm-0.0.1-SNAPSHOT.jar"]
#CMD ["java", "--add-opens", "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED", "-jar", "ajan-hcm-0.0.1-SNAPSHOT.jar"]

# Command to run your application when the container starts
CMD ["java", "--add-opens", "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED", "-Dserver.address=0.0.0.0", "-jar", "ajan-hcm-0.0.1-SNAPSHOT.jar"]

