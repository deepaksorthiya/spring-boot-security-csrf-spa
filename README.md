[![Java Maven Build Test](https://github.com/deepaksorthiya/spring-boot-security-csrf-spa/actions/workflows/maven-build.yml/badge.svg)](https://github.com/deepaksorthiya/spring-boot-security-csrf-spa/actions/workflows/maven-build.yml)
[![Docker Hub badge][dockerhub-badge]][dockerhub]

[dockerhub-badge]: https://img.shields.io/docker/pulls/deepaksorthiya/spring-boot-security-csrf-spa

[dockerhub]: https://hub.docker.com/repository/docker/deepaksorthiya/spring-boot-security-csrf-spa

---

### ** Spring Boot Security with CSRF protection for SPA(Single Page Applications) **

---

# Getting Started

## Requirements:

```
Git: 2.49.0
Spring Boot: 3.4.5
Maven: 3.9+
Java: 21
(Optional)Docker Desktop: Tested on 4.41.0
```

## Angular Frontend

[Angular UI](https://github.com/deepaksorthiya/spring-angular-csrf-frontend)

## Clone this repository:

```bash
git clone https://github.com/deepaksorthiya/spring-boot-security-csrf-spa.git
cd spring-boot-security-csrf-spa
```

## Build Project:

```bash
./mvnw clean package -DskipTests
```

## Run Project:

```bash
./mvnw spring-boot:run
```

OR

```bash
java -jar .\target\spring-boot-security-csrf-spa-0.0.1-SNAPSHOT.jar
```

## (Optional)Build Docker Image(docker should be running):

```bash
./mvnw clean spring-boot:build-image -DskipTests
```

## (Optional)Running On Docker

```bash
docker run -p 8080:8080 --name spring-boot-security-csrf-spa deepaksorthiya/spring-boot-security-csrf-spa:0.0.1-SNAPSHOT
```

## Run on Local minikube Kubernetes using Helm Chart

```bash
cd helm
helm create spring-boot-security-csrf-spa
helm lint spring-boot-security-csrf-spa
helm install spring-boot-security-csrf-spa spring-boot-security-csrf-spa
helm uninstall spring-boot-security-csrf-spa spring-boot-security-csrf-spa
```

## Users for Testing

```
USER1 ==> Username: user Password: password
USER2 ==> Username: admin Password : admin
```

## Testing

** Full Postman API Collection is
available [here](https://www.postman.com/deepaksorthiya/workspace/public-ws/collection/12463530-ec68cbe3-1f88-41ac-a00e-7cb6b7045288?action=share&creator=12463530&active-environment=12463530-55c10ebe-548f-4c1b-a5ec-4d4ed996c033) **

http://localhost:8080/api/login POST <br>
http://localhost:8080/api/logout <br>
http://localhost:8080/api/user <br>
http://localhost:8080/api/user/me <br>
http://localhost:8080/api/admin <br>
http://localhost:8080/api/principal <br>
http://localhost:8080/api/authentication <br>
http://localhost:8080/ <br>
http://localhost:8080/server-info

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/maven-plugin/build-image.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/reference/actuator/index.html)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot//io/validation.html)
* [Flyway Migration](https://docs.spring.io/spring-boot/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


