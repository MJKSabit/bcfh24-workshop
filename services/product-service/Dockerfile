FROM eclipse-temurin:21.0.1_12-jdk-alpine AS builder
WORKDIR /app

COPY gradle gradle
COPY gradlew ./
RUN ./gradlew --version --no-daemon

COPY build.gradle settings.gradle ./
RUN ./gradlew build --no-daemon || return 0

COPY src src
RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:21.0.1_12-jre-alpine AS runtime
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar


ENV PORT=3002
ENV DB_HOST=localhost
ENV DB_PORT=5433
ENV DB_NAME=bcf24
ENV DB_USER=bcf24
ENV DB_PASSWORD=bcf24


EXPOSE 3002
CMD ["java", "-jar", "app.jar"]