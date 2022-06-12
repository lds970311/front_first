#!/bin/bash
for host in hadoop149 hadoop131 hadoop132; do
  echo =============== $host ===============
  ssh $host "zkServer.sh status"
done
