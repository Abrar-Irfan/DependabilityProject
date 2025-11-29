# 1. Use the modern Eclipse Temurin Java 17 image (Alpine version)
FROM eclipse-temurin:17-jdk-alpine

# 2. Set the working directory inside the container
WORKDIR /app

# 3. Copy the built application JAR file into the container
COPY target/*.jar app.jar

# 4. Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]