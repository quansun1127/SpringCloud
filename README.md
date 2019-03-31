# SpringCloud
Demo for 《Spring Cloud微服务实战》

1、模块介绍
eureka-server  SpringCloud服务注册中心
eureka-client  SpringCloud服务提供者
ribbon-customer  SpringCloud服务消费者

2、运行名命令
2.1 启动两个注册中心peer1和peer2
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2

访问地址
http://localhost:1111/
http://localhost:1112/

注：需要在C:\Windows\System32\drivers\etc\hosts中添加
127.0.0.1 peer1
127.0.0.1 peer2

2.2 启动两个服务提供者
java -jar eureka-client-0.0.1-SNAPSHOT.jar --server.port=8081
java -jar eureka-client-0.0.1-SNAPSHOT.jar --server.port=8082

访问地址
http://localhost:8081/hello
http://localhost:8082/hello

2.3 启动服务消费者
java -jar ribbon-customer-0.0.1-SNAPSHOT.jar

访问地址
http://localhost:9000/ribbon-consumer

7 API网管服务
url携带parameter方式，使用?携带，不是书中所说的&
http://localhost:5555/api-a/hello?accessToken=token