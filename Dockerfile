FROM openjdk:11.0.8-slim
VOLUME /tmp
COPY / /build/
RUN cd /build && ./gradlew bootJar && cp build/libs/*.jar /app.jar && cd .. && rm -rf /build
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
