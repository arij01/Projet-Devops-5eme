# Utilise une image OpenJDK sur Alpine Linux
FROM openjdk:17-jdk-alpine

# Définit le répertoire de travail
WORKDIR /app

# Expose le port 8082 pour permettre l'accès à l'application
EXPOSE 8082

# Ajouter le fichier JAR généré dans l'image Docker
ADD target/tp-foyer-5.0.0.jar app.jar

# Définir le point d'entrée pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
