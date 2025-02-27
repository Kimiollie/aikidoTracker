FROM maven:latest
WORKDIR /app
COPY . /app
RUN mvn clean package -Pdocker
ENTRYPOINT ["java", "-jar", "target/AikidoTracker.jar"]