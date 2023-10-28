# Tech Challenge Phase 1
Pos Tech FIAP project

## Team Members
- Gabriel Martins de Miranda - rm352234
- Thiago Merino Rodrigues Barbosa - rm351475
- Guilherme Mazzei Graf - rm351411
- Erich Nelson Silveira Pinton - rm351414

## Documentation

### DDD
- https://miro.com/app/board/uXjVNf1J6J8=

### Postman Collection
- [Postech.postman_collection.json](docs/PosTech.postman_collection.json) inside `docs` directory

### Swagger (openAPI)
- Access [Swagger](http://localhost:8080/swagger-ui/index.html) UI

## Dependencies
- Open JDK 17 - Recommended: [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html)
- [Docker](https://docs.docker.com/get-docker/)

## Running locally

- Build the project: `mvn clean install -DskipTests`
- To start: `docker-compose up -d --build`
- To stop: `docker compose down`
- Database is maintained in volume
