FROM eclipse-temurin:21-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY application/target/*.jar /app/QuickFLights.jar

# Expose the port that your Spring Boot application uses (default is 8080)
EXPOSE 8080

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "QuickFLights.jar"]