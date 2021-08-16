#!/bin/bash

for i in 1
    do
      echo "parando todos os containers" 
      docker stop $(docker ps -q)
      echo "apagando todos os containers" 
      docker rm $(docker ps -a -q)
      echo "removando todas as imagens" 
      docker rmi -f $(docker images -q)
      echo "removendo a subnet prodnet"
      docker network rm prodnet
      docker container ls
      docker images      


sleep 3
done
