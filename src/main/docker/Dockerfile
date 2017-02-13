FROM java:8
MAINTAINER Mahima Agarwal  <mahima.agarwal@gmail.com>

VOLUME /tmp
ADD emp_chargecode-0.0.1-SNAPSHOT.jar  app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8095
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
