# Utilise une image OpenJDK sur Alpine Linux
FROM openjdk:17-jdk-alpine

# Expose le port 8082 pour permettre l'accès à l'application
EXPOSE 8082

# Ajouter le fichier JAR généré dans l'image Docker
ADD target/tp-foyer-5.0.0.jar tp-foyer.jar

# Définir le point d'entrée pour lancer l'application
ENTRYPOINT ["java", "-jar", "/tp-foyer.jar"]
