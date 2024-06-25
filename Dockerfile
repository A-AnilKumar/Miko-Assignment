

# problem in Linkage
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/assignment2-0.0.1-SNAPSHOT.jar assignment2.jar

# Expose the port that the application runs on
EXPOSE 8080

# Define the command to run the application when the container starts
CMD ["java", "-jar", "assignment2.jar"]
