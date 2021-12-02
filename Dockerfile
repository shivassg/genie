FROM openjdk:8
EXPOSE 8080
ADD target/genie-docker.jar genie-docker.jar
ENTRYPOINT ["java", "-jar","/genie-docker.jar"]