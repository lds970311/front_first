#!/bin/bash
if [ $# -lt 1 ]; then
  echo "No Args Input..."
  exit
fi
case $1 in
"start")
  echo " =================== 启动 zookeeper 集群 ==================="
  echo " --------------- 启动 149 ---------------"
  ssh hadoop149 "zkServer.sh start"
  echo " --------------- 启动 131 ---------------"
  ssh hadoop131 "zkServer.sh start"
  echo " --------------- 启动 132 ---------------"
  ssh hadoop132 "zkServer.sh start"
  ;;
"stop")
  echo " =================== 关闭 zookeeper 集群 ==================="
  echo " --------------- 关闭 149 ---------------"
  ssh hadoop149 "zkServer.sh stop"
  echo " --------------- 关闭 131 ---------------"
  ssh hadoop131 "zkServer.sh stop"
  echo " --------------- 关闭 132 ---------------"
  ssh hadoop132 "zkServer.sh stop"
  ;;
*)
  echo "Input Args Error..."
  ;;
esac
