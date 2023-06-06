enum class CoffeeRecepie(private val CName: String, private var cWater:Int, private var cMilk:Int, private var cBeans:Int){
    AMER("Американо", 120, 0, 10),
    ESS("Эспрессо", 60, 0, 10),
    CUP("Капучино", 120, 60, 20),
    LAT("Латте", 240, 120, 20);
    fun makeCoffee(machine: CoffeeMachine) {
        if (machine.water < cWater) {
            println("Недостаточно воды!")
        } else if (machine.milk < cMilk) {
            println("Недостаточно молока!")
        } else if (machine.beans < cBeans) {
            println("Недостаточно кофе!")
        } else {
            machine.water -= cWater
            machine.milk -= cMilk
            machine.beans -= cBeans
            println("$CName готов")
        }
    }
}