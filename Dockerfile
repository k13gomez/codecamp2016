FROM openjdk:8-jre

COPY target/codecamp2016.jar codecamp2016.jar

EXPOSE 3000

CMD java -jar codecamp2016.jar
