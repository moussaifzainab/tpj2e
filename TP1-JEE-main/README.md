# TP 1 – Spring Boot REST API (CRUD)

## Description

Ce projet est une **API RESTful développée avec Spring Boot** permettant la gestion des produits via les opérations **CRUD**.
L’application utilise une **architecture en couches** et peut être exécutée sous différents **profils Spring** (dev, prod, integration).

## Architecture

* Controller : exposition des endpoints REST
* Service : logique métier
* Model : entités métier
* Configuration : gestion des profils et paramètres

Serveur embarqué : Tomcat

## Endpoints principaux

* `GET /hello` : test de l’API
* `GET /products` : liste des produits
* `GET /products/{id}` : produit par ID
* `POST /products` : ajouter un produit
* `PUT /products/{id}` : modifier un produit
* `DELETE /products/{id}` : supprimer un produit

Formats supportés : JSON et XML

## Tests

Les services REST ont été testés avec Postman.

## Screen 

![1](https://github.com/user-attachments/assets/39603f52-fdb0-487a-a23c-26c67a35908d)
![2](https://github.com/user-attachments/assets/2f143081-a1f2-4e8f-bdaf-30d3be932899)
![3](https://github.com/user-attachments/assets/86908a7e-d743-4f55-abf1-400e803d0e73)
![4](https://github.com/user-attachments/assets/008c0234-8207-4f27-b06b-251653a75b5c)
![5](https://github.com/user-attachments/assets/f18979db-6fb8-4daa-b1ec-47549cfe6447)

## Objectifs pédagogiques

* Comprendre Spring Boot
* Créer une API REST
* Implémenter le CRUD
* Gérer les profils Spring
* Packager une application Java en JAR


