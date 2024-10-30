FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/tp-foyer-1.0.2.jar tp-foyer-1.0.2.jar
ENTRYPOINT ["java","-jar","tp-foyer-1.0.2.jar"]