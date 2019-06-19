## Tema Final parte 1 - Cloud native DevOps

### Grupo 4
- Bárbara Becker
- Giovane Pacheco
- Rafael Leite

## Principais recursos utilizados

* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Ferramenta para desenvolver aplicações. Versão 8 utilizada.
* [Spring](https://spring.io/) - O framework java utilizado.
* [Gradle](https://gradle.org/) - Ferramenta de automação e gerenciamento de projetos.
* [Jfrog](https://jfrog.com/) - Gerenciamento Universal de Artefatos para Aceleração de DevOps.
* [Tomcat](https://tomcat.apache.org/download-90.cgi) - Servidor web Java, versão 9 utilizada.
* [Docker](https://www.docker.com/) - Tecnologia de software que fornece contêineres.
* [Ansible](https://www.ansible.com/) - Ferramenta de provisionamento de software, gerenciamento de configuração e implementação de aplicativos.
* [Jenkins](https://jenkins.io/) - Servidor de automação com integração contínua, facilitando os aspectos técnicos da entrega contínua.
* [Packer](https://www.packer.io/) - Ferramenta para criar imagens a partir de uma única configuração de origem.

## Pré-requisitos

O que foi necessário para rodar o projeto: 

- Java na versão 8
- GIT instalado
- Framework Spring
- Docker instalado
- Jfrog instalado
- Jenkins instalado

## JOB 1

- Clonar no projeto privado: 

```
  git clone https://github.com/garciagiovane/jts.cloud-native.2019.1.git
  
```
- Faça o build da aplicação Gradle
- Faça o upload do artifactory **.war** no Jfrog
- No Jenkins, escreva o script gradle:

 ``` 
    clean build artifactoryPublish
    
```

## JOB 2

- Faça o download do artifactory **.war** no Jfrog
- Faça o download dos scripts pelo repositório privado do github
- Faça o build dos scripts do Packer para criar a imagem 
- O script do Packer finaliza o trabalho carregando a imagem para o DockerHub
- No shell do Jenkins digite os comandos:

 ``` 
   wget {URL_JFROG_PARA_DOWLOAD_DO_ARTIFACTORY}
   packer build giovane-pacheco/tema-final-01/arquivos/app.json
    
```

## JOB 3

- Rode o comando no shell do Jenkins para executar o Docker image do Dockerhub

 ``` 
   docker pull rafanleite/grupo04_final:latest
   docker run -p 8085:8080 rafanleite/grupo04_final:latest
       
```

## Rodar os Jobs

- Execute os Jobs em sequência: 

- JOB 1
- JOB 2 
- JOB 3


## Vídeo

[Apresentação](https://youtu.be/aT8SkAU3pdw)
