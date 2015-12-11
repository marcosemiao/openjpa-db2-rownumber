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