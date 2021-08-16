# autodockerdeployinfra

This project is my memory note to deploy 4 containers with node server and flask api website. It is very good infra for training docker skills, automation with bash script and postman requests. 

![diagram](https://user-images.githubusercontent.com/20565821/129620197-abfafe9e-94e9-4825-bebc-efd0076eda84.jpg)

Description

This containers are divided in parts to deploy services as description above:

API - It is a server in Flask framework. It is hosting a website with ansible explanation taken from my college. This simple phyton code can handle http requests. It can response for POST and GET running on http://172.19.0.4:8085/. 

Career - This container provide binaries for node js application. This code was taken from dynatrace Udemy course and all ports are hard coded in his source code. It runs on 172.19.0.5 opening port 8080 for web application get a list of texts. 

Market - This container runs binaries for a server to show information on drop down menu under main web application. 

Webapp - This container runs main web application and show their front page in http://172.19.0.3:3000

Dynatrace - This container runs oneagent monitoring for free try on dynatrace.com. 

File structure must be respected to all containers and configuration work well as they were developed. Each folder contains a Dockerfile and part of files used for each application. 

For deployment you need to run bash scripts in correct order. First you need do do chmod a+x in each one to get correct permissions. 
0- You must have docker installed, of course! 
1- Run on docker full infra folder cleanall.sh - BE CAREFUL - This scrip clear all previous docker containers and images! It is a clean install purpose. You can skip this step. 

2- Run build.sh. This bash script runs docker and setup all images and import all needed files from host.

3- Run start.sh. This bash script starts all containers and deploy all ambient for you. 

4 - This infra is done and can be tested accessing those links: 

Webpage - make POST  and GET via curl to get response. 
http://172.19.0.4:8085/

Web Application - Run drop down menu to access and test communication between containers.
http://172.19.0.3:3000/

Dynatrace Oneagent - provides an agent responsible to inform statics and problems in your structure. Ideal to learn how it works. You must have a account there to get you URL and Token to provide it in docker run command. It is very important to run it without changes. 

      docker run -d --restart=unless-stopped --privileged=true --pid=host --net host --name=oneagent -v /:/mnt/root -e ONEAGENT_INSTALLER_SCRIPT_URL="<take it from your console deploy page>" -e ONEAGENT_INSTALLER_DOWNLOAD_TOKEN=<take it from deploy page> dynatrace/oneagent APP_LOG_CONTENT_ACCESS=1

The environment link must have ""
The environment TOKEN must have any quotes. 
Just run this entire command and Dynatrace Oneagent will scan your host. It is very fast, Just take about 3 minutes.  







