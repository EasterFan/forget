FROM openjdk:8-jdk-alpine
LABEL maintainer = "fan.eastor@gmail.com"
LABEL version = "1.0"
LABEL description = "back-end of lastwish"

COPY build/libs/forget-0.0.1-SNAPSHOT.jar /workdir/app.jar
WORKDIR /workdir
ARG image_version=local
ENV IMAGE_VERSION=$image_version
RUN ["/bin/sh", "-c", "echo -n ${IMAGE_VERSION} > image_version.txt"]
ENTRYPOINT ["java", "-jar", "app.jar"]
