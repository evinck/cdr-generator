package generator.operators

import model._

abstract class OperatorsGenerator() extends Serializable{
	def generate(): Array[Operator]
}

class HarcodedOperatorsGenerator() extends OperatorsGenerator {
	def generate(): Array[Operator] = {
		Array(
			new Operator(1, "operator1", 0.4f),
			new Operator(2, "operator2", 0.6f)
		)
	}
}
