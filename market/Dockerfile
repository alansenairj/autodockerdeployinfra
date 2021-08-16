FROM ubuntu:focal
LABEL description="market"
RUN apt-get update && apt-get -y install openjdk-8-jre -y  && apt-get install unzip -y --no-install-recommends && rm -rf /var/lib/apt/lists/* 
COPY . /market
WORKDIR /market/app/
EXPOSE  8082
#CMD chmod u+x oneagent.sh && ./oneagent.sh 

