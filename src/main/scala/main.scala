import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import com.github.nscala_time.time.Imports._

import spark.Spark.sc
import generator.users._
import generator.operators._
import generator.cells._
import generator.socialnetwork._
import simulator._

object CDRSimulation{
	def main(args: Array[String]){
		val sim = new BasicSimulator(
			new BasicCellsGenerator(10),
			new HarcodedOperatorsGenerator(),
			new BasicUsersGenerator(1000000),
			new RandomSocialNetworkGenerator()
		)
		val dateStart = new DateTime(2018, 1, 1, 0, 0, 0, 0)
		for (daynum <- 0 to 180) {
			val date = dateStart.plusDays(daynum)
			// print("alter table toto add partition timestamp=" + date.toString("YYYY-MM-d")) 
			sim.simulate(date).map(_.toString).saveAsTextFile("cdrs/year=" + date.toString("YYYY") + "/month=" + date.toString("MM") + "/day=" + date.toString("dd"))
		}
	}
}
