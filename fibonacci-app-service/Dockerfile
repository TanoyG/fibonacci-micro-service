FROM openjdk:17.0.2-jdk

WORKDIR '/usr/fibonacci-app'

COPY target/fibonacci-app-service-0.0.1-SNAPSHOT.jar fibonacci-app-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "fibonacci-app-service-0.0.1-SNAPSHOT.jar" , "--server.port=9081"]