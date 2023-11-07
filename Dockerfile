FROM openjdk:22-slim

WORKDIR /app

COPY target/todo-list-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]