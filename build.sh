#!/bin/bash

for i in 1
    do
      echo "construindo career" 
      cd career && docker build -t career .
      echo "construindo webapp" 
      cd .. && cd webapp && docker build -t webapp .
      echo "construindo api"            
      cd .. && cd api && docker build -t api .
      echo "construindo career" 
      cd .. && cd career && docker build -t career .
      echo "construindo market" 
      cd .. && cd market && docker build  -t market .
      docker network create -d bridge --subnet 172.19.0.0/16 prodnet
      docker images      


sleep 3
done
