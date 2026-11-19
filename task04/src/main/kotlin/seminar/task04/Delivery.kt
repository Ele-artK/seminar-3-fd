package seminar.task04

abstract class Delivery(
    val destination: String
) {
    init{
        require(destination.isNotBlank())
    }

    abstract fun cost(weightKg: Int): Int

    fun label(weightKg: Int, destination: String): String {
        val price = cost(weightKg)
        return "Доставка в $destination: $price"
    }
}

class Pickup (destination: String)
       : Delivery(destination) {
    override fun cost(weightKg: Int): Int {
        require(weightKg >= 0)
        return 0
    }

}
class CourierDelivery(destination: String)
       : Delivery(destination) {
    override fun cost(weightKg: Int): Int {
        require(weightKg > 0)
        return 200 + 50*weightKg
    }
}

class ExpressDelivery(
    destination: String,
    distance: Int
) : Delivery(destination) {
    init{
        require(distance > 0)
    }
    override fun cost(weightKg: Int): Int {
        require(weightKg > 0)
        return 300 + 50*weightKg
    }
}




