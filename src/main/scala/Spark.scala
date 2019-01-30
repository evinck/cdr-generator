package spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.io.File


object Spark{
		val conf = new SparkConf()

		val sc = new SparkContext(conf)
}
