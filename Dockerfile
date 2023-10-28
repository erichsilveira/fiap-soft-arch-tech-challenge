FROM maven:3.8.3-openjdk-17 AS builder
ADD ./pom.xml pom.xml
ADD ./src src/
RUN mvn clean package -Dmaven.test.skip=true

FROM amazoncorretto:17.0.8-alpine
#WORKDIR /app
EXPOSE 8080
COPY --from=builder target/techchallenge*.jar techchallenge.jar
ENTRYPOINT ["java", "-jar", "techchallenge.jar"]