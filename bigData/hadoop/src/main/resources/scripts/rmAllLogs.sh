for host in hadoop149 hadoop131 hadoop132; do
  echo =============== $host ===============
  ssh $host rm -rf /usr/local/docker_images/hadoop/hadoop-3.3.3/logs/*
done
