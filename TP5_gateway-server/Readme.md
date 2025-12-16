# TP5 – API Gateway avec Spring Cloud Gateway

## Objectif du TP
L’objectif de ce TP est de mettre en place un **API Gateway** afin de centraliser l’accès aux microservices dans une architecture **Spring Cloud**.

Le Gateway permet :
- de fournir un **point d’entrée unique** pour les clients
- de rediriger les requêtes vers les **microservices appropriés**
- de simplifier la communication entre les services

---

## Choix technique
Dans ce TP, **Spring Cloud Gateway** a été utilisé à la place de **Zuul**.

Ce choix est justifié par le fait que Zuul n’est plus compatible avec les versions récentes de **Spring Boot** et **Spring Cloud**.  
Spring Cloud Gateway est aujourd’hui la solution recommandée pour assurer le **routage**, la **découverte de services** et la **gestion des requêtes** dans une architecture microservices moderne.

---

## Description du travail réalisé
Un serveur **Spring Cloud Gateway** a été configuré comme **API Gateway**.  
Il est enregistré auprès du serveur **Eureka** afin de découvrir automatiquement les microservices disponibles.

Les routes définies dans le Gateway permettent de rediriger les requêtes vers le **microservice Produits** selon des règles de routage précises, sans accès direct au service.

---

## Architecture mise en place
L’architecture du TP est composée de :
- un **serveur Eureka** (Service Registry)
- un **microservice Produits**
- un **serveur Spring Cloud Gateway**

Le client communique uniquement avec le Gateway, qui se charge de transmettre les requêtes vers les microservices internes.

---

## Configuration du Gateway
La configuration du Gateway est définie dans le fichier :
- `application.yml` (ou `application.properties`)

Les routes permettent de :
- mapper les chemins exposés par le Gateway
- rediriger automatiquement vers le microservice Produits enregistré dans Eureka
- éviter tout accès direct aux ports internes des microservices

---

## Lancement de l’application
L’ordre de démarrage respecté est le suivant :
1. Démarrage du **serveur Eureka**
2. Démarrage du **microservice Produits**
3. Démarrage du **serveur Spring Cloud Gateway**

Une fois tous les services lancés, les appels passent obligatoirement par le Gateway.

---

## Résultats et captures d’écran

### 1. Consultation de la configuration via le Gateway
Cette capture montre l’accès au microservice Produits **à travers le Gateway**, avec récupération de la configuration provenant du serveur de configuration.

> URL utilisée : `http://localhost:9101/microservice-produits/Produits`

![Configuration via Gateway](images/gateway-config-produits.png)

---

### 2. Accès direct au microservice Produits
Cette capture montre l’appel direct au microservice Produits sur son port interne, sans passer par le Gateway.

> URL utilisée : `http://localhost:9001/Produits`

![Accès direct microservice Produits](images/microservice-produits-direct.png)

---

### 3. Accès au microservice Produits via le Gateway
Cette capture montre l’accès aux données Produits **uniquement via le Gateway**, confirmant le rôle de point d’entrée unique.

> URL utilisée : `http://localhost:9103/microservice-produits/Produits`

![Accès Produits via Gateway](images/gateway-produits.png)

---

## Fonctionnement observé
Lorsqu’une requête est envoyée vers le Gateway :
- celui-ci identifie le service cible grâce à **Eureka**
- la requête est redirigée automatiquement vers le microservice concerné
- le client n’a aucune connaissance de l’emplacement réel du service

---

## Conclusion
Ce TP met en évidence le rôle central d’un **API Gateway** dans une architecture microservices.

Spring Cloud Gateway permet :
- un accès unifié aux services
- un découplage entre le client et les microservices
- une architecture plus propre, évolutive et sécurisée

Ce travail confirme l’intérêt du Gateway comme composant essentiel dans les architectures Spring Cloud modernes.
