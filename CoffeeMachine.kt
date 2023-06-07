import java.util.Scanner
import Commands.*

class CoffeeMachine {
    var water = 0
    var milk = 0
    var beans = 0
    private var status : Status = Status.FACTION
    private var scanner = Scanner(System.`in`)
    fun start() {
        println("Кофемашина готова к работе")
        while (status != Status.OFF) {
            when (status) {
                Status.FACTION -> this.fAction()
                Status.CHOICE -> this.choice()
                Status.INGRID -> this.ingrid()
                Status.FILL -> this.fill()
                Status.UNKNOWN -> this.unknown()
                Status.STOP -> this.stop()
                else -> println("Неправильный ввод")
            }
        }
    }
    private fun fAction() {
        println("Введите команду")
        val pick = scanner.nextLine()
        this.status = when(true){
            pick.equals(OFF.uComm,ignoreCase = true) -> Status.STOP
            pick.equals(FILL.uComm,ignoreCase = true)-> Status.FILL
            pick.equals(STATUS.uComm,ignoreCase = true)-> Status.INGRID
            pick.equals(COFFEE.uComm,ignoreCase = true)-> Status.CHOICE
            pick.equals(BACK.uComm,ignoreCase = true)-> Status.FACTION
            else -> return
        }
    }
    private fun choice() {
        println("Введите название напитка или \"назад\" для возврата в главное меню")
        val pickC = scanner.nextLine()
        this.status = when(true){
            pickC.equals(BACK.uComm,ignoreCase = true) -> Status.FACTION
            else -> Status.UNKNOWN
        }
        when (true) {
            pickC.equals(CoffeeRecepie.ESS.CName,ignoreCase = true) -> CoffeeRecepie.ESS.makeCoffee(this)
            pickC.equals(CoffeeRecepie.AMER.CName,ignoreCase = true)-> CoffeeRecepie.AMER.makeCoffee(this)
            pickC.equals(CoffeeRecepie.CUP.CName,ignoreCase = true) -> CoffeeRecepie.CUP.makeCoffee(this)
            pickC.equals(CoffeeRecepie.LAT.CName,ignoreCase = true) -> CoffeeRecepie.LAT.makeCoffee(this)
            else -> return
        }
        this.status = Status.FACTION
    }
    private fun ingrid(){
        println("Ингридиентов осталось:")
        println("$water мл. воды")
        println("$milk мл. молока")
        println("$beans гр. кофе")
        this.status = Status.FACTION
    }
    private fun fill() {
        this.water = 2000
        this.milk = 1000
        this.beans = 500
        println("Ингридиенты пополнены")
        this.status = Status.FACTION
    }
    private fun unknown(){
        println("Рецепт не найден!")
        this.status = Status.FACTION
    }
    private fun stop(){
        println("До свидания!")
        this.status = Status.OFF
    }
}
