package parcial

import java.time.LocalDate

class ArmadorTour {
    val listaPersonas = mutableListOf<Persona>()
    val listaPersonasPendientes = mutableListOf<Persona>()
    val listaTours = mutableListOf<Tour>()


    fun agregarTour(tour: Tour) {
        listaTours.add(tour)
    }

    fun armarTours() {
        listaPersonas.forEach { asignarTour(it, toursDisponibles(it)) }
    }

    private fun asignarTour(persona: Persona, toursDisponibles: List<Tour>) {
        if (toursDisponibles.isEmpty()) {
            listaPersonasPendientes.add(persona)
        } else {
            ordenarXPrecioAsc(toursDisponibles).first().agregarPersona(persona)
        }
    }

    fun ordenarXPrecioAsc(tours: List<Tour>): List<Tour> = tours.sortedBy { it.montoXPersona }

    fun toursDisponibles(persona: Persona): List<Tour> = listaTours.filter { it.esAdecuadoPara(persona) }
}

class Tour(
    val fechaSalida: LocalDate,
    var cantidadPersonasRequeridas: Int,
    val lugaresARecorrer: List<Lugar>,
    var montoXPersona: Double
) {
    val personasABordo: MutableList<Persona> = mutableListOf()


    fun esAdecuadoPara(persona: Persona): Boolean =
        lugaresARecorrer.all { persona.esLugarAdecuado(it) } && montoXPersona <= persona.presupuesto && hayEspacioLibre()

    private fun hayEspacioLibre(): Boolean = personasABordo.size < cantidadPersonasRequeridas

    fun agregarPersona(persona: Persona) {
        personasABordo.add(persona)
    }

    fun eliminarPersona(persona: Persona) {
        personasABordo.remove(persona)
    }

    fun codigosDeLugares(): List<Int> = lugaresARecorrer.map { it.codigoAfip }
    fun dniPersonas(): List<Int> = personasABordo.map { it.dni }
}