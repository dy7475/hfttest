FROM node43.com/hft/java:8.2
RUN mkdir /usr/local/tomcat8/webapps/erpWeb
ADD target/erpWeb /usr/local/tomcat8/webapps/erpWeb/