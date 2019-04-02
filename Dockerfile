FROM maven:latest as maven-build
WORKDIR /build
COPY . /build
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
EXPOSE 8081
COPY --from=maven-build /build/target/RoomsGatewayAPI-0.0.1-SNAPSHOT.jar roomapi.jar
ENTRYPOINT ["java", "-jar", "roomapi.jar"]