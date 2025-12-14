# TP5 – API Gateway avec Spring Cloud Gateway

## Objectif du TP
L’objectif de ce TP est de mettre en place un API Gateway afin de centraliser l’accès aux microservices dans une architecture Spring Cloud.

Le Gateway permet :
- de fournir un point d’entrée unique pour les clients
- de rediriger les requêtes vers les microservices appropriés
- de simplifier la communication entre les services

---

## Choix technique
Dans ce TP, Spring Cloud Gateway a été utilisé à la place de Zuul.  
Ce choix est justifié par le fait que Zuul n’est plus compatible avec les versions récentes de Spring Boot et Spring Cloud.

Spring Cloud Gateway est la solution recommandée pour assurer le routage et la gestion des requêtes dans une architecture microservices moderne.

---

## Description du travail réalisé
Un serveur Spring Cloud Gateway a été configuré comme API Gateway.  
Il est enregistré auprès du serveur Eureka afin de découvrir automatiquement les microservices disponibles.

Les routes du Gateway permettent de rediriger les requêtes vers le microservice Produits en fonction des règles définies.

---

## Architecture
L’architecture mise en place est composée de :
- un serveur Eureka (Service Registry)
- un microservice Produits
- un serveur Spring Cloud Gateway

Le client accède uniquement au Gateway, qui se charge de transmettre les requêtes vers les microservices internes.

---

## Configuration du Gateway
La configuration du Gateway est définie localement dans le fichier `application.yml` ou `application.properties`.

Les routes sont configurées pour mapper les chemins du Gateway vers les services enregistrés dans Eureka, sans accès direct aux microservices.

---

## Lancement de l’application
L’ordre de démarrage est le suivant :
1. Démarrage du serveur Eureka
2. Démarrage du microservice Produits
3. Démarrage du serveur Spring Cloud Gateway

Une fois les services lancés, les appels vers le microservice passent obligatoirement par le Gateway.

---

## Fonctionnement observé
Lorsqu’une requête est envoyée vers le Gateway, celui-ci identifie le service cible grâce à Eureka et redirige automatiquement la requête.

Le client n’a pas connaissance de l’emplacement réel des microservices.

---

## Résultat obtenu
Le Gateway assure correctement le rôle de point d’entrée unique.  
Les appels aux microservices sont centralisés et gérés par Spring Cloud Gateway.

---

## Conclusion
Ce TP permet de comprendre le rôle d’un API Gateway dans une architecture microservices et l’intérêt de Spring Cloud Gateway pour le routage et la gestion des requêtes.
