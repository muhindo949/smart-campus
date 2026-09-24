FROM tomcat:10.1-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY target/smart-campus.war /usr/local/tomcat/webapps/smart-campus.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
