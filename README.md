# Etapes de développements

1. Définitions des dtos et controlleur REST
2. Implémentation du client Grand Poitiers
3. Ajout configurations + factory de clients 
5. Refacto controlleur pour gérer de manière transparente plusieurs types de mobilité

# Améliorations

* Filtrer les clients par leur zone de couverture : Si je suis à Paris, ce n'est pas la peine de récupérer les places disponibles à Poitiers 
* Cache sur les appels aux APIs externes ou scheduler pour récuperer les données 
* CRUD des configurations client en BDD
* Gestion des erreurs dans les appels au APIs externes