FROM java:8-jre
MAINTAINER Dimmetr <dimmetr@gmail.com>
ADD ./target/smlr.jar /app/
CMD ["java", "-jar", "/app/smlr.jar"]
EXPOSE 8080