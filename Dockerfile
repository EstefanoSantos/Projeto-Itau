FROM openjdk

WORKDIR /app

COPY . .

RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["java", "-jar", "target/desafioItau-0.0.1-SNAPSHOT.jar"]