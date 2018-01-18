# SITE
=============================

[Spring Boot](http://projects.spring.io/spring-boot/)

[Spring Boot Code](https://github.com/spring-projects/spring-boot/)

[Spring Initializr](http://start.spring.io/)

[Postman](https://www.getpostman.com/)


# Prerequisites
=============================

## 部署
```shell
$ vi ~/.bash_profile
export JAVA_HOME=/opt/jdk1.8.0_151
export M2_HOME=/opt/apache-maven-3.5.2
export PATH=$JAVA_HOME/bin:$M2_HOME/bin:$PATH
export JAVA_OPTS=-Xmx100m
$ java -version
java version "1.8.0_151"
$ mvn -version
Apache Maven 3.5.2
```

## MAVEN
```shell
<repository>
	<id>spring-repo</id>
	<name>Spring Repository</name>
	<url>http://repo.spring.io/release</url>
</repository>

mvn eclipse:clean eclipse:eclipse -DdownloadSources=true
mvn spring-boot:run
mvn clean package docker:build
```
