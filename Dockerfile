FROM openjdk:17-jdk-alpine
MAINTAINER pradoo159
ARG DATABASE_HOST
ENV database_host $DATABASE_HOST
COPY target/booking-service-1.0.0-SNAPSHOT.jar booking-service.jar
ENTRYPOINT ["java","-jar","booking-service.jar"]