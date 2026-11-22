import scala.collection.mutable.ArrayBuffer

class InvalidAdoptionException(message: String)
    extends Exception(message)

object ShelterManager {

    val animals = ArrayBuffer[Animal]()
    val adoptionRecords = ArrayBuffer[AdoptionRecord]()

    def addAnimal(animal: Animal): Unit = {
        animals += animal
        println("Animal added successfully!")
    }

    def viewAnimals(): Unit = {
        if (animals.isEmpty) {
            println("No animals available.")
        } else {
            animals.foreach(_.displayInfo())
        }
    }

    def searchAnimal(id: Int): Unit = {
        animals.find(_.id == id) match {
            case Some(animal) => animal.displayInfo()
            case None => println("Animal not found!")
        }
    }

    def adoptAnimal(id: Int, adopter: String): Unit = {
        animals.find(_.id == id) match {
            case Some(animal) if !animal.adopted =>
                animal.adopted = true
                adoptionRecords += AdoptionRecord(
                    animal.id, animal.name, adopter
                )
                println("Adoption successful!")

            case Some(_) =>
                throw new InvalidAdoptionException("Already adopted!")

            case None =>
                throw new InvalidAdoptionException("Animal not found!")
        }
    }

    def viewAdoptions(): Unit = {
        adoptionRecords.foreach(println)
    }
}