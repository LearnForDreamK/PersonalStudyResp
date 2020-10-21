zookeeper docker 启动

```bash
docker run -d -p 2181:2181 --name some-zookeeper --restart always 3487af26dee9
```



通过命令进入容器中

进入容器中的bin目录可以启动客户端连接服务端
./zkCli.sh -server 120.79.187.164:2181

```bash
docker exec -it c167 /bin/bash
```

进入容器中的bin目录可以启动客户端连接服务端

```bash
./zkCli.sh -server  192.168.0.0:2181
```

