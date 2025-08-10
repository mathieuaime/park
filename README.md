## Architecture

### Composants principaux

#### 1. **model**
Contient les classes communes à toutes les mobilités

#### 2. **web**
Contient les controlleurs REST et les DTOs

#### 3. **service**
- `AvailabilityService` : Interface générique pour les services de disponibilité
- `AvailabilityServices` : Orchestrateur des services par type de mobilité

#### 4. **mobility.parking**
Contient les classes spécifiques à une mobilité (ex: PARKING)

#### 5. **mobility.parking.impl**
Contient les classes spécifiques à une implémentation d'un client pour une mobilité (ex: PARKING Grand Poitiers)

#### 6. **Configuration**
- Configuration externalisée en JSON pour la simplicité

## Démarrage rapide

### Stack Technique
- Java 21
- Maven
- Spring Boot

### Installation et lancement

```bash
git clone <repository-url>
cd park
./mvnw spring-boot:run
```

L'application sera accessible sur `http://localhost:8080`

### API

```bash
curl http://localhost:8080/availabilities/PARKING
```

## Configuration

### Structure de configuration

Le fichier `src/main/resources/data/configuration.json` définit les sources de données :

```json
{
  "configurations": [
    {
      "name": "grand-poitiers",
      "mobility": "PARKING",
      "clientType": "GRAND_POITIERS",
      "url": "https://data.grandpoitiers.fr/data-fair/api/v1/datasets/mobilites-stationnement-des-parkings-en-temps-reel/lines"
    }
  ]
}
```

### Propriétés de configuration

Propriétés communes :
- `name` : Identifiant unique de la configuration
- `mobility` : Type de mobilité (PARKING, Bike, TROTINETTE...)

Propriétés spécifique à une mobilité :
- `clientType` : Type de client à utiliser

Propriétés spécifique à un type de client :
- `url` : Endpoint de l'API externe

## Tests

- Tests unitaires pour les mapper et les services
- Tests des contrôleurs REST avec @WebMvcTest

## Monitoring

### Métriques Prometheus

L'application expose des métriques au format prometheus sur `/actuator/prometheus` :

### Health Checks

- `/actuator/health` : État général de l'application
- `/actuator/health/liveness` : Vérification de liveness
- `/actuator/health/readiness` : Vérification de readiness

## Améliorations possibles

- Gestion d'erreurs des client web (retry / circuit breaker)
- Mettre les données de disponibilités en cache, rafraichit par un batch
- SSE ou WebSocket pour les mises à jour en temps réel des disponibilités
- Configuration des clients en base de données
- Filtres spatiaux sur les positions des parkings pour ne récupérer que les données des parkings proches
