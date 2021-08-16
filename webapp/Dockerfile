FROM ubuntu:20.04
LABEL description="webapp"
EXPOSE 3000
RUN apt-get update && apt-get -y install openjdk-8-jre -y && apt-get install nodejs -y && apt-get install npm -y && apt-get install unzip -y --no-install-recommends && rm -rf /var/lib/apt/lists/* 
COPY . /app
WORKDIR /app
#CMD chmod u+x oneagent.sh && ./oneagent.sh
