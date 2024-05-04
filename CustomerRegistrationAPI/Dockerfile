FROM openjdk:17
CMD ["mvn","clean"]
CMD ["mvn","install"]
ADD target/CustomerRegistration-0.0.1-SNAPSHOT.jar CustomerRegistration-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "CustomerRegistration-0.0.1-SNAPSHOT.jar"]