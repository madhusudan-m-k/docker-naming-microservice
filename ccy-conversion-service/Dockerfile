FROM openjdk:11-ea-11-jdk

EXPOSE ${CCY_CONVERSION_SERVER_PORT}

COPY /target/ccy-conversion-microservice-0.0.1-SNAPSHOT.jar /home/ccy-conversion-microservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar",  "/home/ccy-conversion-microservice-0.0.1-SNAPSHOT.jar", "--server.port=${CCY_CONVERSION_SERVER_PORT}"]
