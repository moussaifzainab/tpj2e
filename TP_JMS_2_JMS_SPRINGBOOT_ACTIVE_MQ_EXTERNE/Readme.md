Très bien.
Voici **un README réécrit simplement**, avec un **style humain, naturel**, comme si tu l’avais rédigé toi-même après avoir fait le TP.
Pas de phrases trop parfaites, pas de vocabulaire “IA”, juste clair et propre.

Tu peux **copier-coller tel quel** dans le `README.md` du TP.

---

# TP JMS 2 – Spring Boot avec ActiveMQ Artemis (broker externe)

## Objectif du TP

L’objectif de ce TP est de mettre en œuvre une communication asynchrone entre deux applications Spring Boot en utilisant **JMS** et un **broker ActiveMQ Artemis externe**.

Ce travail permet de comprendre le rôle d’un broker de messages, la différence entre un producteur et un consommateur, ainsi que le fonctionnement des files (queues) JMS.

---

## Principe de fonctionnement

Le TP est basé sur les éléments suivants :

* Un **broker ActiveMQ Artemis externe**, lancé indépendamment
* Une **application Producteur** Spring Boot qui envoie des messages
* Une **application Consommateur** Spring Boot qui reçoit les messages

Les messages sont envoyés vers une file JMS appelée `message_queue`, configurée en mode **ANYCAST**.

---

## Démarrage du broker ActiveMQ Artemis

Le broker ActiveMQ Artemis est lancé séparément avant les applications Spring Boot.
Une fois démarré, la console d’administration est accessible via le navigateur à l’adresse :

```
http://localhost:8161
```

### Capture 1 – Accès à la console ActiveMQ Artemis

```md
![Console Artemis](captures/console_Artemis.png)
```

Cette page confirme que le broker est bien opérationnel.

---

## Démarrage des applications Spring Boot

Les deux applications Spring Boot (producteur et consommateur) sont lancées normalement.

Dans la console, on observe :

* l’envoi des messages par le producteur,
* la réception immédiate des messages par le consommateur.

### Capture 2 – Console Spring Boot (envoi et réception)

```md
![Console Spring Boot](captures/Console_SpringBoot.png)
```

Cette capture montre clairement que les messages sont bien échangés entre les deux applications.

---

## Supervision via la console ActiveMQ Artemis

La console ActiveMQ Artemis permet de suivre en détail l’activité du broker.

---

### Connexions actives

Cette vue montre les connexions ouvertes entre les applications Spring Boot et le broker.

```md
![Connections](captures/Connection.png)
```

---

### Sessions JMS

Les sessions JMS actives sont visibles dans l’onglet *Sessions*.

```md
![Sessions](captures/Sessions.png)
```

On peut y voir le nombre de producteurs et de consommateurs associés.

---

### Producteurs JMS

La console affiche l’application productrice connectée à la file JMS.

```md
![Producers](captures/producer1.png)
```

---

### Consommateurs JMS

On observe que le consommateur est bien attaché à la file `message_queue`.

```md
![Consumers](captures/1consumer.png)
```

---

### Files JMS (Queues)

La liste des files JMS disponibles sur le broker est visible dans l’onglet *Queues*.

```md
![Queues](captures/Queues.png)
```

On retrouve notamment :

* `message_queue`
* `DLQ`
* `ExpiryQueue`

---

### Détail de la file `message_queue`

Cette vue permet de vérifier l’état de la file utilisée par les applications.

```md
![Message Queue](captures/msg_queue.png)
```

---

### Détails complémentaires de la queue

```md
![Message Queue Details](captures/msg_queue1.png)
```

Ces captures confirment la présence d’un producteur et d’un consommateur actifs.

---

## Conclusion

Ce TP montre le fonctionnement d’une communication asynchrone entre deux applications Spring Boot à l’aide de **JMS** et d’un **broker ActiveMQ Artemis externe**.

Les messages sont correctement envoyés, reçus et supervisés via la console Artemis.
Le TP permet ainsi de bien comprendre le rôle du broker et l’intérêt du messaging dans une architecture distribuée.

---

Si tu veux, je peux faire **le même travail pour un autre TP**, ou relire rapidement ton repo pour vérifier que tout est cohérent avant remise au prof.
