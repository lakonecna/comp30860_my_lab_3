FROM openjdk:8-jre-alpine

COPY target/noteit-0.0.1-SNAPSHOT.jar /noteit.jar
CMD java -jar noteit.jar