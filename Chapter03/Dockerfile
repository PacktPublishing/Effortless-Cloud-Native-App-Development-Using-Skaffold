FROM maven:3-openjdk-16-slim as build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:16-jre-slim
RUN mkdir /project
COPY --from=build /app/target/*.jar /project/app.jar
WORKDIR /project
ENTRYPOINT ["java","-jar","app.jar"]