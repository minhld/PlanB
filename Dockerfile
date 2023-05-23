FROM openjdk:8-jdk-alpine
MAINTAINER minhle
EXPOSE 8080
COPY target/planB-0.0.1-SNAPSHOT.jar planB-0.0.1.jar
ENTRYPOINT ["java","-jar","/planB-0.0.1.jar"]