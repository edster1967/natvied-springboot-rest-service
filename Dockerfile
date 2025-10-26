# Stage 1: Build Environment
FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /opt/app
COPY .mvn/ .mvn/
COPY mvnw mvnw.cmd pom.xml ./

# Verify files are copied and fix permissions/line endings
RUN ls -la && \
    sed -i 's/\r$//' mvnw && \
    chmod +x mvnw

RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime Environment  
FROM eclipse-temurin:17-jre-jammy AS final
WORKDIR /opt/app
EXPOSE 8080

# Copy the built jar
COPY --from=builder /opt/app/target/*.jar /opt/app/app.jar

# Add JVM options for better container and cgroups v2 support
ENV JAVA_OPTS="-XX:+UseContainerSupport \
    -XX:MaxRAMPercentage=75.0 \
    -XX:InitialRAMPercentage=50.0 \
    -XX:+UseG1GC \
    -XX:+UseStringDeduplication \
    -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /opt/app/app.jar"]
