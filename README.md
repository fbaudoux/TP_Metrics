# Metrics

__Lead Dev__ : J'ai une nouvelle mission pour toi. Sur une des API java que nous avons en production,  les clients remontent des problèmes de performance aléatoires selon eux ...

__Vous__ : Sur quelle partie de l'API ? On peut peut être ajouter des traces dans le code ...

__Lead Dev__: Je n'ai pas plus d'infos que cela, j'ai eu les infos par un collègue du support à la machine à café.  
Pour anticiper, j'ai pensé à une solution plus globale pour tracer tous les appels et analyser leur temps d'execution.
On va installer __Prometheus__ et le connecter à notre API.
D'ailleurs c'est toi qui va t'en charger

__Vous__ : ?!? 
Une API Java ... Prometheus ....  Je ne suis pas à l'aise avec tout cela moi !!! 

__Lead Dev__: Relax, on va y aller pas à pas et en plus Docker va beaucoup nous aider.

* Commence par cloner le repository de ce tp

* A la racine du projet, il y a un fichier nommé Dockerfile. 
Ce fichier va nous permettre de construire l'image Docker de l'API Java.
Il suffit de se placer dans le repertoire ou se trouve le fichier et de taper :

```
docker build -t dojoservice .
```

* Ensuite pour lancer l'API, il te suffit d'utiliser le fichier docker-compose.yml qui est également à la racine du projet.

Tu peux vérifier que ton API est bien lancée en te rendant sur la page de documentation de l'API

* http://localhost:8085/swagger-ui.html

Cette API est très simple, elle permet de créer des équipes, des équipiers et de les associer.
Utilise l'interface de documentation pour te familiariser avec l'API

__Vous__  : Ok je maitrise les concepts de l'API

__Lead Dev__ :

Ouvre une page de ton navigateur à l'adresse suivante :   

* http://localhost:8085/actuator/prometheus

__Vous__ :  C'est quoi ce truc ??

__Lead Dev__ : C'est en ensemble de mesures qui sont fournies par notre API concernant , la consommation mémoire , cpu, l'execution des requêtes ... et plein d'autres choses utiles encore ...

__Vous__ : Oui mais moi je ne sais pas lire la matrice à l'oeil nu !

__Lead Dev__ : C'est bien pour cela que l'on va s'outiller avec un outil qui sait faire quelque chose d'utile à partir de ces mesures.

Cet outil s'appelle __prometheus__ , il est utilisable via une image docker qui :
* s'appelle __prom/prometheus__
* expose le port 9090
* utilise un fichier de config qui se trouve en __/etc/prometheus/prometheus.yml__   , je t'ai placé le fichier prometheus.yml à la racine du repository

Tu sauras ajouter ce service dans le docker-compose.yml en mappant le port et le volume ?

__Vous__ : No problemo


__Lead Dev__ : Ok, donc si tu as tout bien suivi tu dois trouver seul l'adresse sur laquelle tu peux accéder à l'interface de prometheus.




