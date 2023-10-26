# BrAPI Java Spring-Boot Test Server

## Server Usage
This server implements all BrAPI calls. It is backed by a custom database with dummy data.

* BrAPI V1 Base URL (v1.0, v1.1, v1.2, v1.3): [test-server.brapi.org/brapi/v1/](https://test-server.brapi.org/brapi/v1/)
* BrAPI V2 Base URL (v2.0, v2.1): [test-server.brapi.org/brapi/v2/](https://test-server.brapi.org/brapi/v2/)

Use [/calls](https://test-server.brapi.org/brapi/v1/call) (V1) or [/serverinfo](https://test-server.brapi.org/brapi/v2/serverinfo) (V2) to check the available endpoints.

## Run

### Java IDE
* Checkout the project and open in your favorite Java IDE.
* Run maven to clean and install dependencies `mvn clean install`
* Setup an empty database server (Postgres is recommended). Create a new database schema, but do not add any tables. The tables and data will be added on server startup.
* Copy `/src/main/resources/application.properties.template` to `/src/main/resources/properties/application.properties`
* Edit `application.properties`
  * Change `server.port` and `server.servlet.context-path` as needed
  * Change the `spring.datasource.` parameters to match your empty database server and schema
  * If you did not use a Postgres database, change the `spring.datasource.driver-class` to match the database type you have setup (this may require additional dependancies in the POM)
* Run `org.brapi.test.BrAPITestServer.BrapiTestServer.java`

### Docker
* Setup an empty database server (Postgres is recommended). Create a new database schema, but do not add any tables. The tables and data will be added on server startup.
* Download [application.properties.template](/src/main/resources/application.properties.template) and rename the file `application.properties`
* Save this file on the docker host as `/<Local_Path_To_Properties>/application.properties`
* Edit `application.properties`
  * Change `server.port` and `server.servlet.context-path` as needed (port 8080 is exposed in the dockerfile by default)
  * Change the `spring.datasource.` parameters to match your empty database server and schema
  * If you did not use a Postgres database, change the `spring.datasource.driver-class` to match the database type you have setup (this may require additional dependancies in the POM, and a fresh build of the docker image)
* Docker Pull `docker pull brapicoordinatorselby/brapi-java-server:v2`
* Docker Run `docker run -v /<Local_Path_To_Properties>/:/home/brapi/properties -d brapicoordinatorselby/brapi-java-server:v2`

## DataBase

The database is created automatically at run time by [flyway](https://documentation.red-gate.com/flyway).
SQL-based migrations under `src/main/resources/db/migration` or `src/main/resources/db/sql`, and Java-based migrations under `src/main/java/org/brapi/test/BrAPITestServer/db/migration` will be run.
The `src/main/resources/db/migration` directory is for schema changes, while `src/main/resources/db/sql` is for dummy data. Modify `spring.flyway.locations` in `application.properties` to change what flyway runs.

When running in Docker, you can edit or add dummy data by adding the volume `-v /<Local_Path_To_SQL>/:/home/brapi/sql` to your docker command. 

Below is a UML diagram of the whole database schema:

![dbSchema](https://raw.githubusercontent.com/plantbreeding/brapi-Java-TestServer/brapi-server-v2/brapi_test_server_data_model_v2.0.svg)
