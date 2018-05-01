
# Aliyun ECS
=============================
## ECS
```
-root/Wxl5******6
39.105.87.116(公)/172.17.222.82(私有)
```

## 防火墙
```
进行“VPC网络安全组配置”，以使通过公网IP访问ECS私有IP/端口服务。
```

# 安装jdk
```
# cat /etc/redhat-release 
CentOS Linux release 7.4.1708 (Core) 
# yum list | grep java
# yum install java-1.8.0-openjdk
# java -version
openjdk version "1.8.0_161"
```

# 启动WS应用
```
$ java -jar sb-demo-webservice-cxf-1.0.jar --server.port=9080 2>&1 > demo-ws.log &
$ curl http://localhost:9080/soap/user?wsdl
$ curl http://39.105.87.116:9080/soap/user?wsdl
```

# 本地使用CSB的客户端工具测试WS服务
```
$ java -jar ws-sdk-1.0.4.2plus.jar \
  -api user -version 1.0.0 \
  -wa http://39.105.87.116:9080/soap/user?wsdl \
  -ea http://39.105.87.116:9080/soap/user \
  -ns http://service.demo/ -sname UserServiceImplService -pname UserService \
  -rd '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.demo/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:getName>
         <!--Optional:-->
         <userId>1234</userId>
      </ser:getName>
   </soapenv:Body>
</soapenv:Envelope>' \
  -d
```

# Aliyun ECS
=============================
## PING(ws发布成ws 透传)
```
https://shared.csb.cn-beijing.aliyuncs.com:9081/PING/vcsb.ws/ws2ws?wsdl

$ java -jar ws-sdk-1.0.4.2plus.jar \
  -ak f94f47f4a7af47849a8b96a392f123c2 \
  -sk rw9KRy07yV45zjxCcuYVTcwXyas= \
  -api PING -version vcsb.ws \
  -wa https://shared.csb.cn-beijing.aliyuncs.com:9081/PING/vcsb.ws/ws2ws?wsdl \
  -ea https://shared.csb.cn-beijing.aliyuncs.com:9081/PING/vcsb.ws/ws2ws \
  -ns http://ws2restful.PING.csb/ -sname PING -pname ws2restfulPortType \
  -rd '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:test="http://ws2restful.PING.csb/">
<soapenv:Header/>
<soapenv:Body>
   <test:ws2restful>
      <name>abc</name>
   </test:ws2restful>
</soapenv:Body>
</soapenv:Envelope>' \
  -d
```

## UserService(ws发布成ws 透传)[测试未成功]
```
# 发布服务

# 订购服务

# 测试服务
WSDL - https://shared.csb.cn-beijing.aliyuncs.com:9081/user/1.0.0/ws2ws?wsdl

$ java -jar ws-sdk-1.0.4.2plus.jar \
  -ak f94f47f4a7af47849a8b96a392f123c2 \
  -sk rw9KRy07yV45zjxCcuYVTcwXyas= \
  -api user -version 1.0.0 \
  -wa http://shared.csb.cn-beijing.aliyuncs.com:9081/user/1.0.0/ws2ws?wsdl \
  -ea http://shared.csb.cn-beijing.aliyuncs.com:9081/user/1.0.0/ws2ws \
  -ns http://service.demo/ -sname UserServiceImplService -pname UserService \
  -rd '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.demo/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:getName>
         <!--Optional:-->
         <userId>1234</userId>
      </ser:getName>
   </soapenv:Body>
</soapenv:Envelope>' \
  -d
```

