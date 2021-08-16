FROM python:rc-buster
LABEL description="api"
EXPOSE 8085
RUN apt-get update && pip3 install flask  && apt-get install unzip -y --no-install-recommends && rm -rf /var/lib/apt/lists/* 
COPY . /api
WORKDIR /api
#CMD chmod u+x oneagent.sh && ./oneagent.sh
