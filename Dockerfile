FROM openjdk:8-jdk-alpine
MAINTAINER minhle
EXPOSE 8080
COPY target/planb-0.0.1-SNAPSHOT.jar planb-0.0.1.jar
ENTRYPOINT ["java","-jar","/planb-0.0.1.jar"]