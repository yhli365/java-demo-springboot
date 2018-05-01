
# webservice
```
$ mvn package spring-boot:repackage -DskipTests
$ java -jar target/sb-demo-webservice-cxf-*.jar --server.port=9080 --server.address=127.0.0.1
http://127.0.0.1:8080/soap/user?wsdl
```
