FROM openjdk:8
COPY targettimesheet_devops-1.0.jar timesheet_devops-1.0.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","timesheet_devops-1.0.jar"]