FROM maven:3-adoptopenjdk-16 as build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean verify -DskipTests

FROM adoptopenjdk:16-jre
RUN mkdir /project
COPY --from=build /app/target/*.jar /project/app.jar
WORKDIR /project
ENTRYPOINT ["java","-jar","app.jar"]