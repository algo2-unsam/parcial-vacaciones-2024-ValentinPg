import java.time.LocalDate

//Utilizo una abstract class ya que tiene estado (el nombre)
abstract class Lugar(val nombre: String) {
    //Utilizo un template method con un metodo que voy a redefinir en cada tipo de lugar
    fun esDivertido(): Boolean = nombrePar() && condicionLugar()

    abstract fun condicionLugar(): Boolean

    private fun nombrePar(): Boolean = (nombre.length % 2) == 0
}

class Ciudad(nombre: String, var cantidadHabitantes: Int, var cantidadDecibeles: Double) : Lugar(nombre) {

    //Utilizo val en vez de var ya que no va a hacer falta cambiar la referencia de la lista
    val atraccionesTuristicas: MutableList<String> = mutableListOf()

    override fun condicionLugar(): Boolean = atraccionesTuristicas.size > 3 && cantidadHabitantes > 100000

    fun agregarAtraccion(atraccion: String) {
        atraccionesTuristicas.add(atraccion)
    }
}

class Pueblo(nombre: String, val extension: Double, val fechaFundacion: LocalDate, val provincia: String) :
    Lugar(nombre) {
    override fun condicionLugar(): Boolean = fechaFundacion.year == provincia.length
}

class Balneario(nombre: String, var metrosPlaya: Double, var esMarPeligroso: Boolean, var tienePeatonal: Boolean) :
    Lugar(nombre) {
    override fun condicionLugar(): Boolean {
        TODO("Not yet implemented")
    }
}

object Litoral {
    val provincias: MutableList<String> = mutableListOf("Entre Ríos", "Corrientes", "Misiones")

    fun estaIncluida(provincia: String): Boolean = provincias.contains(provincia)
}

