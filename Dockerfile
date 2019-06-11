FROM java:8
VOLUME /tmp
ADD /target/test-walle-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","-Xms512M","-Xmx512M","-Xmn256M","-Xss256K","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","/app.jar"]
CMD ["hello worlds"]