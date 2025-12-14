# TP1 – Spring Boot + REST + CRUD (Application JAR)

## Présentation générale

Ce TP a pour objectif de découvrir les bases de **Spring Boot** et le développement de **services RESTful**.
Il consiste à créer une application Java packagée sous forme de **JAR**, exposant des **API REST** permettant de gérer des produits à travers des opérations CRUD (Create, Read, Update, Delete).

L’application est construite avec **Spring Boot**, sans base de données, en utilisant une **liste statique** pour stocker les données.

---

## Objectifs du TP

* Créer un projet Spring Boot à l’aide de **Spring Initializr**
* Comprendre le rôle de l’annotation `@SpringBootApplication`
* Développer des **contrôleurs REST**
* Implémenter les opérations CRUD
* Packager et exécuter une application Spring Boot en **JAR**
* Tester les services REST avec **Postman**
* Comprendre la notion de **Spring Profiles**
* Utiliser des fichiers de configuration internes et externes

---

## Architecture de l’application

L’application est organisée selon une architecture simple en couches :

* **Controller** : exposition des endpoints REST
* **Service** : logique métier
* **Model** : représentation des objets métiers (Product)
* **Configuration** : fichiers `application.properties` selon l’environnement

---

## Démarrage de l’application

Par défaut, l’application démarre sur le port **8080**.

---

## Gestion des produits – ProductController

Un contrôleur REST nommé `ProductController` permet de gérer des produits via les endpoints suivants :

* `GET /products` : liste des produits
* `GET /products/{id}` : récupérer un produit par id
* `POST /products` : ajouter un produit
* `PUT /products/{id}` : modifier un produit
* `DELETE /products/{id}` : supprimer un produit

Les données sont stockées dans une **liste statique** côté service.

---

## Tests avec Postman

Les services REST sont testés à l’aide de **Postman** :

* Test GET pour récupérer la liste des produits
* Test POST pour ajouter un produit
* Test PUT pour modifier un produit
* Test DELETE pour supprimer un produit

### Capture à insérer

![1](https://github.com/user-attachments/assets/39603f52-fdb0-487a-a23c-26c67a35908d)
![2](https://github.com/user-attachments/assets/2f143081-a1f2-4e8f-bdaf-30d3be932899)
![3](https://github.com/user-attachments/assets/86908a7e-d743-4f55-abf1-400e803d0e73)
![4](https://github.com/user-attachments/assets/008c0234-8207-4f27-b06b-251653a75b5c)
![5](https://github.com/user-attachments/assets/f18979db-6fb8-4daa-b1ec-47549cfe6447)

---


## Configuration externe

Spring Boot permet également d’utiliser un fichier de configuration externe grâce à l’option :

```
-Dspring.config.location
```

Cela permet de modifier la configuration sans recompiler l’application.

---

## Conclusion

Ce TP permet de poser les bases du développement avec **Spring Boot** et **REST**.
Il offre une première approche concrète de la création d’API, de leur test, ainsi que de la gestion de la configuration selon les environnements.
