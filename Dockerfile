# ========== BUILD STAGE ==========
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and download dependencies first (build cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy entire project
COPY src ./src

# Build application
RUN mvn clean package -DskipTests

# ========== RUN STAGE ==========
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
