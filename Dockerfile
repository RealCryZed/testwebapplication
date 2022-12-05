# Build application
FROM adoptopenjdk/maven-openjdk12 AS build
COPY src /testwebapplication/src
COPY pom.xml /testwebapplication
RUN mvn -f /testwebapplication/pom.xml clean package spring-boot:repackage

# Run application
FROM openjdk:12
COPY --from=build /testwebapplication/target/testwebapplication.jar /usr/local/lib/testwebapplication.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/testwebapplication.jar"]