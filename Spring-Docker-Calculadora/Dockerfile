FROM ubuntu:18.04

RUN apt-get update && apt-get install openjdk-8-jdk -y

RUN apt-get install wget -y

RUN wget http://mirror.nbtelecom.com.br/apache/tomcat/tomcat-9/v9.0.20/bin/apache-tomcat-9.0.20.tar.gz

RUN tar -xzf apache-tomcat-9.0.20.tar.gz -C /home/

COPY ./arquivos-do-war/build/libs/arquivos-do-war-1.0-SNAPSHOT.war /home/apache-tomcat-9.0.20/webapps

ENTRYPOINT ["/home/apache-tomcat-9.0.20/bin/catalina.sh", "run"]

EXPOSE 8080
