# OpenJpa DB2 Row Number Dictionary

## Fonctionnalités générales
Cette librairie est un plug-in pour Open JPA pour utiliser la fonction "**ROW_NUMBER**" de DB2 au lieu d'effectuer un "**FETCH FIRST**" pour la pagination.

- Facile d'utilisation, il suffit de rajouter la dépendance Maven avec le scope "**runtime**" dans votre application.
- Disponible sur le repository central de Maven.
- Compatible à partir de Java 6.
- Compatible à partir de la version 1.0.1 d'Open JPA.
- Compatible avec l'implémentation d'Open JPA de IBM WebSphere.

## Utilisation rapide
- Ajouter la dépendance dans votre projet :

````xml
<dependency>
	<groupId>com.github.marcosemiao.openjpa.db2.rownumber</groupId>
	<artifactId>openjpa-db2-rownumber</artifactId>
	<scope>runtime</scope>
	<version>1.0.1</version>
</dependency>
````

Open JPA utilise le service loader de Java, ce plugin sera chargé automatiquement.

## Fonctionnement
Lors de la pagination, ce plugin englobe la requete d'origine dans une autre pour effectuer la pagination.

Prenons la requete suivante : SELECT * FROM TOTO
On désire retourner les elements compris entre la 50ème position et la 100ème position. Le plugin va executer cela : 

````sql
SELECT * FROM (
	SELECT rr.*, ROW_NUMBER() OVER(ORDER BY ORDER OF rr) AS row_number_openjpa_db2 FROM (
		SELECT * FROM TOTO
	) AS rr
) WHERE row_number_openjpa_db2 > 50 and row_number_openjpa_db2 <= 100
````

