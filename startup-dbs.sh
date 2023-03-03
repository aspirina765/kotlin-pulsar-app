#!/usr/bin/env bash

/bin/bash cleanup.sh ;

/bin/bash run-mysql-docker.sh 1 ; # 0 = sem user e password ; 1 = com user e password

sudo chmod u+x /home/rhel9prod/scripts/MYSQL ;
sudo chown -R rhel9prod:users /home/rhel9prod/scripts/MYSQL ;

/bin/bash run-mongo-docker.sh ;
/bin/bash run-hbase-docker.sh ;
#/bin/bash run-spark-docker.sh ;
#/bin/bash run-zeppelin-docker.sh ;
#/bin/bash run-flink-docker.sh ;
#/bin/bash run-hadoop-spark-workbench-docker.sh ;