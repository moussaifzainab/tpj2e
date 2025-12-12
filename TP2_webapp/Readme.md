# TP2 – WebApp Spring Boot + Microservice REST API (Gestion des employés)

## Objectif du TP
Dans ce TP, le but est de réaliser une petite application de gestion des employés en deux parties :
- un microservice REST (CRUD employés) avec Spring Boot
- une WebApp Spring Boot (Thymeleaf) qui consomme l’API via RestTemplate
- utilisation de la base H2 (in-memory) pour stocker les données
- tests des opérations CRUD (GET, POST, PUT, DELETE) avec Postman si besoin

## Architecture (principe)
L’utilisateur passe par la WebApp (front) sur le port 9001.  
La WebApp appelle le microservice (API) sur le port 9000.  
Le microservice accède à la base H2. :contentReference[oaicite:0]{index=0}

## Travail réalisé (résumé)
- Microservice EmployeesMngt :
  - modèle Employee + repository + service + controller REST
  - endpoints CRUD (ex : /employees)
  - configuration H2 + console H2
- WebApp :
  - MVC avec Thymeleaf (pages HTML)
  - RestTemplate (EmployeeProxy) pour communiquer avec l’API
  - affichage liste employés + ajout / modification / suppression

## Lancement
1) Démarrer le microservice (port 9000)  
2) Démarrer la WebApp (port 9001)  
3) Tester :
- API : `http://localhost:9000/employees`
- WebApp : `http://localhost:9001/`
- Console H2 : `http://localhost:9000/h2-console`

## Captures d’écran
- Console H2 (connexion + table employees)
![Console H2](captures/H2_console.png)
![Table employés](captures/table_emp.png)
- Test /employees dans le navigateur ou Postman
![Navigation](captures/test_nav.png)
![Test Postman](captures/test_postman.png)
- Démarrage WebApp + port 9001
![Démarrage WebApp](captures/demarragewepapp.png)

- Page liste des employés
![Liste employés](captures/liste_emp.png)
- Formulaire d’ajout d’un employé
![Ajout employé](captures/formulaire_ajout.png)
- Modification d’un employé
![Modification employé](captures/modif.png)
- Suppression d’un employé
![Suppression employé](captures/suppression.png)

## Résultat obtenu
La WebApp récupère les employés depuis le microservice via RestTemplate et les affiche avec Thymeleaf.
Les opérations CRUD fonctionnent et les données sont stockées dans H2 pendant l’exécution.

## Conclusion
Ce TP m’a permis de comprendre la séparation WebApp / API REST, et la communication entre deux composants via HTTP (RestTemplate), avec persistance H2.
