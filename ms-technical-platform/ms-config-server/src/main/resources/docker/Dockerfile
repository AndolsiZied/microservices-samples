FROM openjdk:8-jre
RUN mkdir -p /usr/local/services
ADD  @project.build.finalName@.jar /usr/local/services/
ADD run.sh docker-entrypoint.sh
RUN chmod +x docker-entrypoint.sh
#uncomment this lines if you launch docker behind proxy
#ENV http_proxy "proxy url
#ENV https_proxy "proxy url"
RUN cd /tmp/ && \
    curl -k -LO "http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip" -H 'Cookie: oraclelicense=accept-securebackup-cookie' && \
    unzip jce_policy-8.zip && \
    rm jce_policy-8.zip && \
    yes |cp -v /tmp/UnlimitedJCEPolicyJDK8/*.jar /docker-java-home/jre/lib/security/
ENTRYPOINT ["sh", "docker-entrypoint.sh"]