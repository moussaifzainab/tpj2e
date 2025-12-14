# TP JMS 2 – Messaging avec Spring Boot et ActiveMQ Artemis (Broker Externe)

## Objectif du TP
L’objectif de ce TP est de mettre en place une communication asynchrone entre une application Spring Boot et un broker ActiveMQ Artemis externe.

Contrairement au TP précédent, le broker n’est pas intégré à l’application, mais démarré séparément.  
Ce TP permet de comprendre comment une application Spring Boot peut se connecter à un broker JMS distant.

---

## Présentation générale
Dans ce TP, un broker ActiveMQ Artemis est installé et lancé indépendamment de l’application Spring Boot.

L’application Spring Boot agit comme :
- un producteur de messages JMS
- un consommateur de messages JMS

Les messages envoyés sont des objets Java (Product) et sont échangés via une file JMS appelée `message_queue`.

---

## Architecture mise en place
L’architecture du TP est composée de :
- un broker ActiveMQ Artemis externe
- une application Spring Boot
- une queue JMS (`message_queue`)
- un producer JMS
- un consumer JMS

La communication entre le producer et le consumer se fait de manière asynchrone à travers le broker.

---

## Démarrage du broker ActiveMQ Artemis
Le broker ActiveMQ Artemis est d’abord lancé séparément à l’aide de la commande prévue à cet effet.

Une fois le broker démarré, la console d’administration est accessible via le navigateur, ce qui permet de suivre l’activité des messages et des connexions.

### Capture à insérer
*(Démarrage du broker ActiveMQ Artemis externe dans la console)*  
👉 **Image à placer ici**

---

## Configuration de l’application Spring Boot
L’application Spring Boot est configurée pour se connecter au broker externe en précisant :
- l’adresse du broker
- le port de connexion
- les informations d’authentification

Cette configuration permet à l’application d’envoyer et de recevoir des messages JMS via le broker.

---

## Envoi des messages JMS (Producer)
Au démarrage de l’application Spring Boot :
- plusieurs objets Product sont créés
- chaque objet est envoyé vers la queue `message_queue`
- un message est affiché dans la console pour confirmer chaque envoi

L’envoi des messages se fait automatiquement à l’aide de `JmsTemplate`.

### Capture à insérer
*(Console Spring Boot montrant l’envoi des messages)*  
👉 **Image à placer ici**

---

## Réception des messages JMS (Consumer)
Un consumer JMS est configuré pour écouter la queue `message_queue`.

À chaque message reçu :
- le consumer récupère l’objet Product
- le contenu du message est affiché dans la console

Cette étape confirme que la communication asynchrone fonctionne correctement.

### Capture à insérer
*(Console Spring Boot montrant la réception des messages)*  
👉 **Image à placer ici**

---

## Supervision via la console ActiveMQ
La console ActiveMQ Artemis permet de visualiser :
- les connexions actives
- les producteurs et consommateurs
- la queue `message_queue`
- le nombre de messages envoyés et consommés

Cette interface permet de vérifier le bon fonctionnement du système de messaging.

### Capture à insérer
*(Console ActiveMQ montrant la queue et les connexions)*  
👉 **Image à placer ici**

---

## Résultat obtenu
Les messages envoyés par l’application Spring Boot sont correctement :
- transmis au broker externe
- stockés dans la queue JMS
- consommés par le consumer
- visibles dans la console ActiveMQ et dans la console Spring Boot

---

## Conclusion
Ce TP m’a permis de comprendre le fonctionnement du messaging JMS avec un broker externe, ainsi que la communication asynchrone entre une application Spring Boot et ActiveMQ Artemis.
