FROM amazoncorretto:17.0.8-alpine
WORKDIR /app
EXPOSE 8080
ADD target/techchallenge*.jar techchallenge.jar
ENTRYPOINT ["java", "-jar", "techchallenge.jar"]