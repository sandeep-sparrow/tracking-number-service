FROM openjdk:17-slim
VOLUME /tmp
COPY target/tracking-number-service-0.0.1-SNAPSHOT.jar tracking-number-microservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tracking-number-microservice.jar"]