FROM openjdk:8-jdk-alpine
ADD build/libs/DojoService*.jar DojoService.jar
ADD src/main/resources/application.properties /application.properties
ENV JAVA_OPTS="-Xmx1024m"
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /DojoService.jar

EXPOSE 8085


