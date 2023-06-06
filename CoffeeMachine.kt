import java.util.Scanner
class CoffeeMachine {
    var water = 0
    var milk = 0
    var beans = 0
    var status : Status = Status.FACTION
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
        val pick = scanner.nextLine().lowercase()
        this.status = when(pick){
            "выключить"-> Status.STOP
            "наполнить"-> Status.FILL
            "статус"-> Status.INGRID
            "кофе"-> Status.CHOICE
            "назад"-> Status.FACTION
            else -> return
        }
    }
    private fun choice() {
        println("Введите название напитка или \"назад\" для возврата в главное меню")
        val pickC = scanner.nextLine().lowercase()
        this.status = when(pickC){
            "назад" -> Status.FACTION
            else -> Status.UNKNOWN
        }
        when (pickC) {
            "эспрессо" -> CoffeeRecepie.ESS.makeCoffee(this)
            "американо" -> CoffeeRecepie.AMER.makeCoffee(this)
            "капучино" -> CoffeeRecepie.CUP.makeCoffee(this)
            "латте" -> CoffeeRecepie.LAT.makeCoffee(this)
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