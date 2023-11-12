FROM openjdk:17-jdk-slim

EXPOSE 8080

ADD build/libs/ILY-BE-0.0.1-SNAPSHOT.jar ILY-BE-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","ILY-BE-0.0.1-SNAPSHOT.jar"]