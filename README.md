# market

### Requirement

- Docker
- Java 17

## Installation

Run docker command to download postgres image:

``docker pull postgres``

Run docker command to initialize and start container:

``docker run -itd --name {docker_container_name} -e POSTGRES_USER={username} -e POSTGRES_PASSWORD={password} -e POSTGRES_DB={db_name} -p {exposed_port}:5432 postgres``

Replace variable by your information: 

  - {docker_container_name}: the docker container name used to identify your postgres container between other docket container.
  - {username}: the username used to connect to postgres database
  - {password}: the password used to connect to postgres database
  - {db_name}: the database name to create in the docker container
  - {exposed_port}: the exposed port to access to postgres database

Update application configuration present in `ressources` package with name `aplication.yml` with database configuration. 