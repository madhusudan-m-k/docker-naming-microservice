FROM openjdk:11-ea-11-jdk

WORKDIR /home

EXPOSE ${NAMING_SERVER_PORT}
#EXPOSE 8761

COPY /target/ccy-naming-service-0.0.1-SNAPSHOT.jar ccy-naming-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar",  "ccy-naming-service-0.0.1-SNAPSHOT.jar", "--server.port=${NAMING_SERVER_PORT}"]
#ENTRYPOINT [ "java", "-jar",  "ccy-naming-service-0.0.1-SNAPSHOT.jar", "--server.port=8761"]
