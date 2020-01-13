#Run docker image in interactive mode (terminal will hang until image instance/container is shutdown)

```
docker run image name
```

#Run docker image in backgroun/daemon mode. The terminal will return to promt view to take other commands

```
docker run -d <image name>
```

#Run docker image in backgroun/daemon mode with the container port exposed over another external port number.

```
docker run -p external_port:container_port -d <image name>

or

docker container run -p external_port:internal_port -d <image_name/image_id>
```

#View the container logs of images run in daemon mode. in this command the terminal displays the logs and return to command prompt ready to take next command

```
docker logs container_id
```

#View the container logs of images run in daemon mode tailing the logs

```
docker logs -f container_id
```

#Return the list of container running ONLY.

```
docker container ls
```

#Return the list of container running and exited. (-a switch return even the exited images)

```
docker container ls -a
```

#Stop running containers.

```
docker container stop <container_id>

e.g. docker container stop afe34d

stop multiple containers
e.g. docker container stop 23xfeg

docker stop $(docker ps -a -q)

```

#Search for images on Docker hub

```
docker search <image name>
```

#Tagging a image with a new name

```
docker tag in28min/todo-rest-api:1.0.0.RELEASE in28min/todo-rest-api:latest
```

#To view the history or list of steps involved in create the image

```
docker image history <image_name/id>

or

docker history <image_name/id>
```

#Details inspection of the entire image configuration

```
docker image inspect <image_name/id>
```

#remove docker image

```
docker rmi <image_name/id>

or

docker image remove <image_name/id>
```

#inspect a running container

```
docker container inspect <container_name/image_id>
```

#pause a running container

```
docker container pause <container_name/id>

docker container unpause <container_name/id>
```

#kill a running docker container

```
docker container kill <container_name/id>
```

#Remove a particular container

```
docker container rm <container_id or container_name>
e.g. docker container rm ea323fc
e.g. docker container rm mysql
```

### Remove multiple containers at once

```
e.g. docker container rm ea323f a4568 234gf
```

#Remove all stopped container

```
docker container prune
```

#Start a container to always start when the docker daemon restarts

```
docker container run -p external_port:internal_port -d --restart=always <image_name/image_id>
```

#Docker event monitoring.. start and stop of container etc

```
docker events
```

#show docker process stats similar to task manager across container.

```
docker stats
```

#view the processes running within a container

```
docker container top 98e42b3a24c2
```

#start a new container with a SPECIFIED RAM and CPU QUOTA (max cpu quota is 100000. define cpu as subset of that e.g. 25000). Watch the stats to make sure the memory and cpu are used according to settings

```
docker container run -p 5000:5000 -d -m 512m --cpu-quota 30000 in28min/todo-rest-api-h2:1.0.0.RELEASE
```

#List the images and container status (similar to disk usage in Linux)

```
docker system df
```

#Run container in interactive mode i=Interactive t=tty -

```
docker container run -dit <image_name/image_id>

e.g. interactive command
docker container exec <container_id> <command>
docker container exec naught_knuth ls /tmp
```

#Enter interactive shell on the container

```
docker exec -it <container_name> bash
e.g. docker exec -it mysql-db-container bash
docker exec -it microservice-container bash
```

#remove container

```
docker container rm <container_id/name>

--Remove all containers
docker rm $(docker ps -a -q)

```

#remove container after exiting and login into interactive SQL shell for mysql

```
docker run -it --network some-network --rm mysql mysql -hsome-mysql -uexample-user -p
```

#non docker remote access

```

\$ docker run -it --rm mysql mysql -hsome.mysql.host -usome-mysql-user -p
```

#copy file/folder between host and container or container to host

```
docker container cp <filename/folder_name> <container_id>:<unix path>
e.g. docker container cp /home/work/my-spring-jar.jar abed132321:/home
```

#save the container image

```
docker container commit <container_id> <new_image_name>
```

#Update containter to have an entry point command -

```
docker container commit --change "CMD [\"java\",\"-jar\",\"/home/dockerhelloworld-0.0.1-SNAPSHOT.jar\"]" 7f5c4cf61519 dockerhelloworld-openjdk:manual2
```

#build a docker image using a Dockerfile (-t is to specify tagname)

```
docker build -t dockerhelloworld:auto1 .
```

##### docker file spotify plug - reads the Dockerfile in the project folder and create the image

##### JIB maven plug - No docker file is needed or used. It has default configuration to create spring boot image automatically. Further customization is allowed with regards to base image, exposed port, jvm argument etc.

##### fabric8io maven plug - hybrid of spotify and jib plugin. Can use Docker file if provided or has it own syntax to take docker instructions.

#Starting mysql docker image

```
docker run -dit -p 3307:3306 --name mysql -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=tododb -e MYSQL_USER=todouser -e MYSQL_PASSWORD=todopassword mysql:8.0.18

--name Gives an alias name to the container like docker give those funny random suedo name
-e option to pass environment variable (key value pair)
-d run in detached mode
-it interactive terminal/tty
```

Abbreviated command -

```
docker run -dit --publish 3307:3306 --name mysql --env MYSQL_ROOT_PASSWORD=rootpassword --env MYSQL_DATABASE=tododb --env MYSQL_USER=todouser --env MYSQL_PASSWORD=todopassword mysql:8.0.18
```

Using environment file for setting up enviornment variables

```
docker container run -dit -p 9090:9090 --name currency-exchange-service --env-file .env --network ccyconversionservice_currency-bridge currency-exchange-service:0.0.1-SNAPSHOT
```

Run WebApp connecting to the DB container -
\*\*Link (Deprecated approach)

```
E:\>docker run -dit -p 3307:3306 --name mysql --env MYSQL_ROOT_PASSWORD=rootpassword --env MYSQL_USER=todouser --env MYSQL_PASSWORD=todopassword --env MYSQL_DATABASE=tododb mysql:8.0.18
```

###Linking 2 container to talk to each other (link spring-mvc-mysql webapp with mysql database container) BUT they cannot use localhost as "their host" is their _container_ name and not physical host they are running on.

```
docker container run -dit -p 8080:8080 --link=mysql --env RDS_HOST_NAME=mysql --env RDS_HOST_PORT=3307 madhusudanmkrishnamurthy/hello-spring-mvc-mysql-mvn-spotify:0.0.1-SNAPSHOT
```

### Run WebApp connecting to the DB container previously started (Deprecated approach) -

```
docker run -dit -p 8080:8080 --link=mysql --env RDS_HOST_NAME=mysql --env RDS_HOST_PORT:3307 madhusudanmkrishnamurthy/hello-spring-mvc-mysql-mvn-spotify:0.0.1-SNAPSHOT

\*\* Bridge approach

docker network ls

docker network create web-mysql-network

docker network ls

```

### Run database on the newly created network -

```
docker run -dit -p 3307:3306 --name mysql-bridge --env MYSQL_ROOT_PASSWORD=rootpassword --env MYSQL_USER=todouser --env MYSQL_PASSWORD=todopassword --env MYSQL_DATABASE=tododb --network web-mysql-network mysql:8.0.18

\*\* This command doesn't work (with RDS_HOST_PORT)
docker run -dit -p 8080:8080 --network web-mysql-network --name web-bridge --env RDS_HOST_NAME=mysql-bridge --env RDS_HOST_PORT:3036 madhusudanmkrishnamurthy/hello-spring-mvc-mysql-mvn-spotify:0.0.1-SNAPSHOT

\*\* This WORKED (without RDS_HOST_PORT)
docker run -dit -p 8080:8080 --network web-mysql-network --name web-bridge --env RDS_HOST_NAME=mysql-bridge madhusudanmkrishnamurthy/hello-spring-mvc-mysql-mvn-spotify:0.0.1-SNAPSHOT

```

### Provide volumes to Container to persist infor across container deletes/prune and share the data between containers

```

docker run -dit -p 3307:3306 --name mysql-bridge --env MYSQL_ROOT_PASSWORD=rootpassword --env MYSQL_USER=todouser --env MYSQL_PASSWORD=todopassword --env MYSQL_DATABASE=tododb --network web-mysql-network --volume mysql-database-volume:/var/lib/mysql mysql:8.0.18

```

### Short cut parameter - Provide volumes to Container to persist infor across container deletes/prune and share the data between containers

```

docker run -dit -p 3307:3306 --name mysql-bridge --env MYSQL_ROOT_PASSWORD=rootpassword --env MYSQL_USER=todouser --env MYSQL_PASSWORD=todopassword --env MYSQL_DATABASE=tododb --network web-mysql-network -v mysql-database-volume:/var/lib/mysql mysql:8.0.18
```

###Use mount (recommended approach) to mount volume

```

docker run -dit -p 3307:3306 --name mysql-bridge --env MYSQL_ROOT_PASSWORD=rootpassword --env MYSQL_USER=todouser --env MYSQL_PASSWORD=todopassword --env MYSQL_DATABASE=tododb --network web-mysql-network --mount source=mysql-database-volume,target=/var/lib/mysql mysql:8.0.18
```

###Inspect Volume

```

docker volume inspect mysql-database-volume
```

###Delete a volume

```

docker volume rm mysql-database-volume
```

###spring JWT security
www.springboottutorial.com/spring-boot-react-full-stack-with-spring-security-basic-and-jwt-authentication

## Docker Compose

#### componse and start docker containers

```

docker-compose up
```

### run in detached mode

```

docker-compose up -d
```

### just build the docker compose file.

```

docker-compose -f "docker-compose.yml" up -d --build
```

### tear down services and resource started with docker-compose up

```

docker-compose down
```

### docker compose config will show the docker compose file used to start the services

```

docker-compose config
```

### show all the container and images managed by docker-compose

```
docker-compose images
```

### Show all the running container started by docker compose

```

docker-compose ps
```

### show all the processes running within each container started by docker-compose

```

docker-compose top
```

### pause and unpause containers

```

docker-compose pause
docker-compose unpause
```

### stop all containers started by docker-compose

```

docker-compose stop
```

### kill all containers started by docker-compose

```

docker-compose kill
```

### prune all container

```

docker-compose rm
```

### docker build within docker compose (where ever build element is pointing to Docker file)

```

docker-compose build
```

###Lookup

```

docker-compose run
```

### Docker compone build and force recreate all images

```

docker-compose up -d --build --force-recreate

```
