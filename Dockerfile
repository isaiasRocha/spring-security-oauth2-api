FROM openjdk:17-alpine

WORKDIR /app-project

COPY target/*.jar /app-project/project-api.jar

EXPOSE 8085

CMD ["java","-jar","project-api.jar"]

  

