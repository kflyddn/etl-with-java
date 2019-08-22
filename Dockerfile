## Build phase
FROM gradle:5.3.1-jdk11-slim as gradle_build
ADD --chown=gradle ./ /app
WORKDIR /app
RUN ./gradlew build --stacktrace

## Run phase
FROM openjdk:11.0.3-jre-slim

COPY --from=gradle_build /app/build/libs/bbl.etl-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java -jar app.jar"]
