FROM openjdk:17-oracle

ADD build/libs/PersonalProjectWebApplication.jar /data/PersonalProjectWebApplication.jar

ADD config.yml /data/config.yml

CMD java -jar /data/PersonalProjectWebApplication.jar server /data/config.yml

EXPOSE 80