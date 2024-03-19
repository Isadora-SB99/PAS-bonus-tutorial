FROM openjdk
WORKDIR /app
COPY target/layer-based-applic-0.0.1-SNAPSHOT.jar /app/layerbasedapplic.jar
ENTRYPOINT ["java", "-jar", "layerbasedapplic.jar"]