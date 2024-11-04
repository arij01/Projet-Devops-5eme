FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier le fichier JAR dans le conteneur
COPY target/Devops-Integration.jar /app/Devops-Integration.jar

# Expose le port de l'application
EXPOSE 8085

# Commande pour exécuter le fichier JAR
CMD ["java", "-jar", "/app/Devops-Integration.jar"]
