FROM maven as build
WORKDIR /build
COPY pom.xml .
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/RoomsGatewayAPI-Api-0.0.1-SNAPSHOT.jar  room.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","room.jar"]
