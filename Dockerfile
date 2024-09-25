FROM maven:3.9.4-openjdk-21 AS build
COPY src /home/app/src/
copy pom.xml /home/app/
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:21
COPY --from=build "target/saguntokids_docker-1.0.jar" "app.jar"
EXPOSE 8888
ENTRYPOINT ["java","-jar","app.jar"]