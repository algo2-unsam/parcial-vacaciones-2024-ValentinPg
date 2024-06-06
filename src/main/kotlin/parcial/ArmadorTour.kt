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
        listaPersonas.forEach {}
    }

    fun ordenarXPrecioAsc(): List<Tour> = listaTours.sortedBy { it.montoXPersona }

    fun toursDisponibles(persona: Persona): List<Tour> = listaTours.filter { it.esAdecuadoPara(persona) }
}

class Tour(
    val fechaSalida: LocalDate,
    var cantidadPersonasRequeridas: Int,
    val lugaresARecorrer: List<Lugar>,
    var montoXPersona: Double
) {
    val personasABordo: MutableList<Persona> = mutableListOf()

    fun confirmar() {}

    fun esAdecuadoPara(persona: Persona): Boolean =
        lugaresARecorrer.all { persona.esLugarAdecuado(it) && montoXPersona <= persona.presupuesto }

    fun agregarPersona(persona: Persona) {
        personasABordo.add(persona)
    }
}