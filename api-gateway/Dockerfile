FROM eclipse-temurin:21-jdk AS build

WORKDIR /workspace

COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle

RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

COPY src ./src
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre

WORKDIR /app

RUN groupadd --system app && useradd --system --gid app app

COPY --from=build /workspace/build/libs/*.jar app.jar

EXPOSE 4003

USER app:app

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
