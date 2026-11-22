
abstract class Animal(
    val id: Int,
    val name: String,
    val age: Int
) {
    var adopted: Boolean = false

    def animalType: String

    def displayInfo(): Unit = {
        println("Animal ID: " + id)
        println("Name: " + name)
        println("Age: " + age)
        println("Type: " + animalType)
        println("Status: " + (if (adopted) "Adopted" else "Available"))
        println("---------------------------")
    }
}

class Dog(id: Int, name: String, age: Int)
    extends Animal(id, name, age) {

    override def animalType: String = "Dog"
}

class Cat(id: Int, name: String, age: Int)
    extends Animal(id, name, age) {

    override def animalType: String = "Cat"
}
