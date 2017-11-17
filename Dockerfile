# build image : `docker build -f .\Dockerfile -t brapi-java-server ./`
# run container : `docker run --name=brapi --network=bridge -p 8081:8081 -d brapi-java-server`

FROM nimmis/java-centos:oracle-8-jre

EXPOSE 8081

RUN mkdir /home/brapi

COPY target/brapi-Java-TestServer-0.0.1-SNAPSHOT.jar src/main/resource/application.properties src/main/resource/import.sql /home/brapi/

CMD java -cp "/home/brapi/:/home/brapi/brapi-Java-TestServer-0.0.1-SNAPSHOT.jar" org.springframework.boot.loader.JarLauncher