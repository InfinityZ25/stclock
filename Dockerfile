# TODO Build the image for the spring restful api later.
FROM openjdk:17.0.1-oraclelinux8

ARG JAR_FILE=build/libs/stclock-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar


EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]