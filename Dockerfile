FROM node43.com/hft/java:8.2
RUN mkdir /usr/local/tomcat8/webapps/kpiWeb
ADD target/kpiWeb /usr/local/tomcat8/webapps/kpiWeb/