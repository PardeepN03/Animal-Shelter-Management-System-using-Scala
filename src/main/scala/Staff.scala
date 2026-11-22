
case class Staff(
    id: Int,
    name: String,
    role: String
)

object StaffManager {

    var staffList = scala.collection.mutable.ArrayBuffer[Staff]()

    def addStaff(staff: Staff): Unit = {
        staffList += staff
        println("Staff added successfully!")
    }

    def viewStaff(): Unit = {
        if (staffList.isEmpty) {
            println("No staff records found.")
        } else {
            println("\n===== STAFF DETAILS =====")
            staffList.foreach { staff =>
                println("Staff ID: " + staff.id)
                println("Name: " + staff.name)
                println("Role: " + staff.role)
                println("----------------------")
            }
        }
    }
}
