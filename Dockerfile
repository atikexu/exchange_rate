FROM openjdk:11
COPY target/*.jar challenge-0.0.1-SNAPSHOT.jar
#EXPOSE 8092
ENTRYPOINT ["java","-jar","/challenge-0.0.1-SNAPSHOT.jar"]