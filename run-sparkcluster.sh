cd ./target/scala-2.10/
spark-submit --class CDRSimulation --master yarn-cluster --num-executors 3 --driver-memory 512m --executor-memory 512m --executor-cores 1 CDR-Generator-assembly-1.0.jar 
