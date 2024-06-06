package parcial

import java.time.LocalDate

//punto 1
//Utilizo una abstract class ya que tiene estado (el nombre)
abstract class Lugar(val nombre: String, val codigoAfip: Int) {
    //Utilizo un template method con un metodo que voy a redefinir en cada tipo de lugar
    fun esDivertido(): Boolean = nombrePar() && condicionLugar()

    abstract fun condicionLugar(): Boolean

    private fun nombrePar(): Boolean = (nombre.length % 2) == 0

    //Punto 2
    abstract fun esTranquilo(): Boolean
}

class Ciudad(
    nombre: String, var cantidadHabitantes: Int, var cantidadDecibeles: Double,
    codigoAfip: Int
) : Lugar(nombre, codigoAfip) {
    val UMBRAL_RUIDOSO = 20

    //Utilizo val en vez de var ya que no va a hacer falta cambiar la referencia de la lista
    val atraccionesTuristicas: MutableList<String> = mutableListOf()

    override fun condicionLugar(): Boolean = atraccionesTuristicas.size > 3 && cantidadHabitantes > 100000

    fun agregarAtraccion(atraccion: String) {
        atraccionesTuristicas.add(atraccion)
    }

    //Punto 2
    override fun esTranquilo(): Boolean = cantidadHabitantes < UMBRAL_RUIDOSO
}

class Pueblo(
    nombre: String, val extension: Double, val fechaFundacion: LocalDate, val provincia: String,
    codigoAfip: Int
) :
    Lugar(nombre, codigoAfip) {
    //Lo defino como una constante por si el día de mañana la tengo que cambiar y para que sea mas cohesivo el codigo
    val FECHA_ANTIGUO = 1800
    override fun condicionLugar(): Boolean = esAntiguo() || esDelLitoral()

    private fun esAntiguo(): Boolean = fechaFundacion.year < FECHA_ANTIGUO

    private fun esDelLitoral(): Boolean = Litoral.estaIncluida(provincia)

    //Punto 2
    override fun esTranquilo(): Boolean = provincia == "La Pampa"
}

class Balneario(
    nombre: String, var metrosPlaya: Double, var esMarPeligroso: Boolean, var tienePeatonal: Boolean,
    codigoAfip: Int
) :
    Lugar(nombre, codigoAfip) {
    //Lo defino como una constante por si el día de mañana la tengo que cambiar y para que sea mas cohesivo el codigo
    val LONGITUD_PLAYA_LARGA = 300
    override fun condicionLugar(): Boolean = playaAmplia() && esMarPeligroso

    private fun playaAmplia(): Boolean = metrosPlaya > LONGITUD_PLAYA_LARGA

    //Punto 2
    override fun esTranquilo(): Boolean = !tienePeatonal
}

//Utilizo un WKO porque me va servir si el dia de mañana tambien necesito otras funcionalidades que reconzocan al Litoral
//Usar una case no tiene mucho sentido debido a que si quiero cambiar que provincias componen el Litoral, tenddría que cambiar c/u de ellas
object Litoral {
    val provincias: MutableList<String> = mutableListOf("Entre Ríos", "Corrientes", "Misiones")

    fun estaIncluida(provincia: String): Boolean = provincias.contains(provincia)
}

