FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/bloomload.jar /bloomload/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/bloomload/app.jar"]
