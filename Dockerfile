FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/SandshipGames-0.0.1-SNAPSHOT.jar SandshipGames-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "-Dspring.datasource.url=jdbc:postgresql://postgres:5432/spring","/SandshipGames-0.0.1-SNAPSHOT.jar"]