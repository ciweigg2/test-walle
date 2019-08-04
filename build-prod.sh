#!/bin/sh
#进入文件根目录
#cd "$WORKSPACE"
 
#启用 prod 配置
ActiveProfiles=prod
 
#基本信息需要配置
#内部端口
targetPort=8080
#旧镜像版本号
oldVendor=1.0.0
#镜像版本号
vendor=1.0.0
#项目名
projectName=test-walle-0.0.1
 
#进入target文件夹
#直接的构建是再容器里，这个是在 Jenkins 容器里，所以空间不一样
#容器的空间是原空间路径后面多了 @2
#多模块使用
#cd $WORKSPACE@2/$projectName/target
#单模块使用
cd $WORKSPACE@2/target
 
#创建Dockerfile文件
#-jar -Duser.timezone=GMT+08 保证生成出来的容器的时区与服务器一致
cat << EOF > Dockerfile
FROM kdvolder/jdk8
MAINTAINER $projectName
VOLUME /tmp
LABEL app="$projectName" version="$vendor" by="$projectName"
COPY /target/$projectName.jar $projectName.jar
EXPOSE $targetPort
#多环境使用
#CMD -Xmx100m -Xms100m -jar -Duser.timezone=GMT+08 $projectName.jar --spring.profiles.active=$ActiveProfiles
#单环境使用
CMD -Xmx100m -Xms100m -jar -Duser.timezone=GMT+08 $projectName.jar
ENTRYPOINT java
EOF
 
#删除镜像下所有容器
docker rm -f $(docker ps -a | grep "$projectName" | awk '{print $1}')
 
#删除旧镜像
docker rmi -f $projectName:$oldVendor
 
#创建镜像
docker build -t $projectName:$vendor .
 
#启动镜像生成容器
docker run --name $projectName -d -p $targetPort:$targetPort $projectName:$vendor
