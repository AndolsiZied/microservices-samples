FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/local/services
ADD  @project.build.finalName@.jar /usr/local/services/
ADD run.sh docker-entrypoint.sh
RUN chmod +x docker-entrypoint.sh
ENTRYPOINT ["sh", "docker-entrypoint.sh"]