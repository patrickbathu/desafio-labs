FROM adoptopenjdk/openjdk11
FROM maven:alpine
WORKDIR /app
ADD pom.xml /app
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ADD target/desafio-luizalabs-0.0.1-SNAPSHOT.jar /developments/
ENTRYPOINT ["java","-jar","/developments/desafio-luizalabs-0.0.1-SNAPSHOT.jar"]
