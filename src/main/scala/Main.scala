
object Main {

  def main(args: Array[String]): Unit = {

    ShelterManager.addAnimal(new Dog(1, "Bruno", 3))
    ShelterManager.addAnimal(new Cat(2, "Kitty", 2))

    var choice = 0

    while (choice != 8) {

      println("\n================================")
      println("   ANIMAL SHELTER MANAGEMENT")
      println("================================")
      println("1. Add Animal")
      println("2. View All Animals")
      println("3. Search Animal")
      println("4. Adopt Animal")
      println("5. View Adoption Records")
      println("6. Add Staff")
      println("7. View Staff")
      println("8. Exit")
      print("Enter your choice: ")

      try {
        choice = scala.io.StdIn.readInt()

        choice match {

          case 1 =>
            print("Enter Animal ID: ")
            val id = scala.io.StdIn.readInt()

            print("Enter Animal Name: ")
            val name = scala.io.StdIn.readLine()

            print("Enter Animal Age: ")
            val age = scala.io.StdIn.readInt()

            print("Enter Type (Dog/Cat): ")
            val animalType = scala.io.StdIn.readLine()

            if (animalType.equalsIgnoreCase("Dog")) {
              ShelterManager.addAnimal(new Dog(id, name, age))
            } else if (animalType.equalsIgnoreCase("Cat")) {
              ShelterManager.addAnimal(new Cat(id, name, age))
            } else {
              println("Invalid animal type!")
            }

          case 2 =>
            ShelterManager.viewAnimals()

          case 3 =>
            print("Enter Animal ID: ")
            val id = scala.io.StdIn.readInt()
            ShelterManager.searchAnimal(id)

          case 4 =>
            print("Enter Animal ID: ")
            val id = scala.io.StdIn.readInt()

            print("Enter Adopter Name: ")
            val adopter = scala.io.StdIn.readLine()

            try {
              ShelterManager.adoptAnimal(id, adopter)
            } catch {
              case e: InvalidAdoptionException =>
                println("Error: " + e.getMessage)
            }

          case 5 =>
            ShelterManager.viewAdoptions()

          case 6 =>
            print("Enter Staff ID: ")
            val id = scala.io.StdIn.readInt()

            print("Enter Staff Name: ")
            val name = scala.io.StdIn.readLine()

            print("Enter Staff Role: ")
            val role = scala.io.StdIn.readLine()

            StaffManager.addStaff(Staff(id, name, role))

          case 7 =>
            StaffManager.viewStaff()

          case 8 =>
            println("Thank you for using Animal Shelter Management System!")

          case _ =>
            println("Invalid choice! Please try again.")
        }

      } catch {
        case _: NumberFormatException =>
          println("Please enter a valid number!")
      }
    }
  }
}

