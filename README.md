# coffeemachine

This is a coffee machine REST service for remote control.

This is a test task for AISA (https://aisa.ru/) company.

It's based on Spring Boot 3 (with Spring 6), with Web, Data JPA
and Security profile. Also, I'm using Flyway DB migration,
Lombok, and some additional libraries.

API docs: `/api-docs.html`

## Starting up

```shell
#Step 1
./mvnw clean package

#Step 2
# Copy .jar file from /target directory to /docker

# Step 3
# Run in the /docker folder
docker compose up -d
```