FROM adoptopenjdk/openjdk11:latest


VOLUME /tmp

#RUN update-ca-certificates -v

ARG VERSION

WORKDIR /etc/app

ADD target/service.jar /etc/app/service.jar

EXPOSE 8080 8080

RUN echo '#!/bin/sh' >  ./entrypoint.sh \
 && echo 'exec java -jar  /etc/app/service.jar'   >> ./entrypoint.sh

RUN chmod +x ./entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]