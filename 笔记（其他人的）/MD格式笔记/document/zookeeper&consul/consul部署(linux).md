docker 拉取 consul 镜像



```undefined
docker pull consul
```

启动 server
 启动前, 先建立 `/data/consul` 文件夹, 保存 consul 的数据



```kotlin
mkdir -p /data/consul
```

使用 docker run 启动 server

![image-20200804152447868](C:\Users\h'p\Desktop\MD格式笔记\document\zookeeper&consul\consul部署(linux).assets\image-20200804152447868.png)

```kotlin
docker run -d -p 8500:8500 -v /data/consul:/consul/data -e CONSUL_BIND_INTERFACE='eth0' --name=consul1 consul agent -server -bootstrap -ui -client='0.0.0.0'
```

- `agent`: 表示启动 agent 进程
- `server`: 表示 consul 为 server 模式
- `client`: 表示 consul 为 client 模式
- `bootstrap`: 表示这个节点是 Server-Leader
- `ui`: 启动 Web UI, 默认端口 8500
- `node`: 指定节点名称, 集群中节点名称唯一
- `client`: 绑定客户端接口地址, 0.0.0.0 表示所有地址都可以访问

一般第一个容器的ip地址是 172.17.0.2，可以通过下面的命令查询容器ip：



```bash
docker inspect --format '{{ .NetworkSettings.IPAddress }}' consul1
```

往集群插入其他节点



```csharp
docker run -d --name=consul2 -e CONSUL_BIND_INTERFACE=eth0 consul agent --server=true --client=0.0.0.0 --join 172.17.0.2;
docker run -d --name=consul3 -e CONSUL_BIND_INTERFACE=eth0 consul agent --server=true --client=0.0.0.0 --join 172.17.0.2;
docker run -d --name=consul4 -e CONSUL_BIND_INTERFACE=eth0 consul agent --server=false --client=0.0.0.0 --join 172.17.0.2;
```

- `join`: 表示加入到指定集群中

查看集群下面的节点



```bash
docker exec -it consul1 consul members
```

至此 consul 的部署已经完成。

上述只搭建了dc1，下面开始搭建dc2，并将dc1和dc2关联起来



```kotlin
docker run -d --name=consul5 -e CONSUL_BIND_INTERFACE='eth0' consul agent -server -bootstrap-expect 3 -datacenter=dc2
```

往dc2添加节点



```csharp
docker run -d --name=consul6 -e CONSUL_BIND_INTERFACE=eth0 consul agent --datacenter=dc2 --server=true --client=0.0.0.0 --join 172.17.0.6;
docker run -d --name=consul7 -e CONSUL_BIND_INTERFACE=eth0 consul agent --datacenter=dc2 --server=true --client=0.0.0.0 --join 172.17.0.6;
docker run -d --name=consul8 -e CONSUL_BIND_INTERFACE=eth0 consul agent --datacenter=dc2 --server=false --client=0.0.0.0 --join 172.17.0.6;
```

关联dc1和dc2



```css
docker exec -it consul6 consul join -wan 172.17.0.2  
```

