# build image : `docker build -f .\Dockerfile -t brapicoordinatorselby/brapi-java-server ./`
# run container (dev): `docker run --name=brapi-test-server --network=bridge -p 8081:8081 -d brapicoordinatorselby/brapi-java-server`
# run container (prod): `docker run --name=brapi-test-server --network=bridge -d brapicoordinatorselby/brapi-java-server`

FROM nimmis/java-centos:oracle-8-jre

EXPOSE 8080

RUN mkdir /home/brapi

COPY target/brapi-Java-TestServer-0.0.1-SNAPSHOT.jar src/main/resources/ /home/brapi/

CMD java -cp "/home/brapi/:/home/brapi/brapi-Java-TestServer-0.0.1-SNAPSHOT.jar" org.springframework.boot.loader.JarLauncher