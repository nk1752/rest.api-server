FROM openjdk:17-alpine

# set timezone in docker container
ENV TZ=America/Chicago
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN addgroup -S viva && adduser -S devops -G viva
USER viva:devops

EXPOSE 8080

# ADD
# COPY
# ENV
# EXPOSE
# FROM
# LABEL
# STOPSIGNAL
# USER
# VOLUME
# WORKDIR
# ONBUILD
# configure ARG with --build-arg jar=
# ARG project
# ARG branch
# ARG commit
# ARG job
# ARG build
# ARG date
ARG jar

# LABEL project=$project
# LABEL branch=$branch
# LABEL commit=$commit
# LABEL job=$job
# LABEL build=$build
# LABEL date=$date

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} restapiserver.jar
# ENTRYPOINT ["java","-jar","/nk-poc.jar"]
ENTRYPOINT exec java -jar /restapiserver.jar