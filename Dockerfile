FROM eclipse-temurin:17-jdk-jammy

ADD target/money_transfer_service-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]