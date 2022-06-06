FROM openjdk:14
COPY ./alpha-bank-test-task-0.0.1-SNAPSHOT.jar alphaapp.jar
ENTRYPOINT ["java","-jar","/alphaapp.jar"]

