FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier le fichier JAR dans le conteneur
COPY target/Devops-Integration.jar /app/Devops-Integration.jar  # Remplacez "ADD" par "COPY" et assurez-vous que le nom est correct

# Expose le port de l'application
EXPOSE 8080

# Commande pour exécuter le fichier JAR
CMD ["java", "-jar", "/app/Devops-Integration.jar"]
