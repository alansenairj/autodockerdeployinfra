#!/bin/bash

echo -n "Enter oneagent commad from deploy page and press [ENTER]: "
read run

for i in 1
    do
      echo "Iniciando oneagent" 
      exec $run
      echo "Iniciando webapp na URL http://172.19.0.3:3000"
      docker container run -d --net prodnet --ip=172.19.0.3 --name webapp$i alanaguinaga/webapp node /app/app/app.js
      echo "Iniciando webapi na URL http://172.19.0.4:8085"
      docker run -d --net prodnet --ip=172.19.0.4 --name api$i alanaguinaga/api python3 api.py
      echo "Iniciando career"
      docker run -d --net prodnet --ip=172.19.0.5 --name career$i alanaguinaga/career java -jar /career/app/careerws/jar/career-path-0.0.1-SNAPSHOT.jar
      echo "Iniciando market"
      docker run -d --net prodnet --ip=172.19.0.6 --name market$i alanaguinaga/market java -Dserver.port=8082 -jar /market/app/mktws/jar/mkt-sentiment-0.0.1-SNAPSHOT.jar
      echo "containers inicados:"
      docker ps -q | grep "$name"
sleep 3
done
