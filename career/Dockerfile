FROM ubuntu:focal
LABEL description="career"
RUN apt-get update && apt-get -y install openjdk-8-jre -y && apt-get install unzip -y   --no-install-recommends && rm -rf /var/lib/apt/lists/* 
COPY . /career
WORKDIR /career/app/careerws/jar
EXPOSE  8080
CMD java -jar career-path-0.0.1-SNAPSHOT.jar 
#WORKDIR /career/app
#CMD chmod u+x oneagent.sh && ./oneagent.sh && python3 api.py
