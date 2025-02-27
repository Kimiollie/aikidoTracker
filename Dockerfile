FROM maven:latest
WORKDIR /app
COPY . /app
RUN mvn clean package
ENTRYPOINT ["java", "-jar", "target/AikidoTracker.jar"]