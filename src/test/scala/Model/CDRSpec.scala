import org.scalatest.FlatSpec
import org.joda.time.DateTime
import model._

class CDRSpec extends FlatSpec {
	def fixture = new {
		val cdr = new CDR(
			DefaultDumUser,
			DefaultDumUser,
			DefaultCell,
			DefaultCell,
			new DateTime(),
			100,
			SMS)
	}

	"CDR.toString fields" should "be in the same order as the fields return by the header function" in {
		val cdr = fixture.cdr
		val fields = cdr.toString(",").split(",")
		val header = cdr.header(",").split(",")

		header.zip(fields).foreach{ case (h,f) =>
				h match {
					case "fromUserId" => assert( f == cdr.fromUser.id.toString )
					case "toUserId" => assert( f == cdr.toUser.id.toString )
					case "fromCell" => assert( f == cdr.fromCell.id.toString )
					case "toCell" => assert( f == cdr.toCell.id.toString )
					case "fromOperator" => assert( f == cdr.fromUser.operator.name )
					case "toOperator" => assert( f == cdr.toUser.operator.name )
					case "duration" => assert( f == cdr.duration.toString )
					case "date" => assert( f == cdr.date.toString("%y%m%d%h%s") )
					case "type" => assert( f == CDRType.toString(cdr.cdrType))
					case _ => assert(false)
				}
			}
	}
	it should "remain the same" in {
		val cdr = fixture.cdr
		val headerFields = cdr.header(",").split(",")
		val fields = Array(
			"fromUserId", 
			"toUserId",  
			"fromCell", 
			"toCell",  
			"fromOperator", 
			"toOperator", 
			"duration", 
			"date", 
			"type"
			)
		fields.foreach( f => assert(headerFields.contains(f)) )
	}

}