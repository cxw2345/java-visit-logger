# 第一阶段：编译
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app

# 先把 settings.xml 拷进去
COPY settings.xml .
COPY pom.xml .
COPY src ./src

# 使用 -s 参数指定刚才那个阿里云镜像配置文件
RUN mvn clean package -s settings.xml -DskipTests

# 第二阶段：运行
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]