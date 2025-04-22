FROM openjdk:25-ea-jdk-oraclelinux8

RUN mkdir -p /app

WORKDIR /app

COPY recipe-backend/build/libs/*.jar ./app.jar

EXPOSE 6060

CMD ["java", "-jar", "./app.jar"]