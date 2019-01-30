sbt assembly
cd ./target/scala-2.10/
spark-submit --class CDRSimulation --master yarn-cluster --num-executors 400 --driver-memory 50g --executor-memory 512m --executor-cores 1 CDR-Generator-assembly-1.0.jar 
