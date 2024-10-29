FROM openjdk:17
EXPOSE 8089
ADD target/tp-foyer-1.0.0.jar tp-foyer-1.0.0.jar
ENTRYPOINT ["java","-jar","tp-foyer-1.0.0.jar"]