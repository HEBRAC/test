FROM openjdk:11 
ADD ./target/apirest01-0.0.1-CJAVA.jar apirest01.jar 
ENTRYPOINT ["java","-jar","/apirest01.jar"] 