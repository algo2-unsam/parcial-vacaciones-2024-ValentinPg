package parcial

//Punto 4
class Admin {
    //Voy a utilizar el patron observer para defenir las acciones que se van a realizar automaticamente cada vez que el admin confirma un tour
    //De esta forma puedo agregar y quitar acciones cuando quiero
    val confirmarObservers: MutableList<ConfirmarObserver> = mutableListOf<>()
    fun agregarPersonaATour(persona: Persona, tour: Tour) {
        tour.agregarPersona(persona)
    }

    fun eliminarPersonaDeTour(persona: Persona, tour: Tour) {
        tour.eliminarPersona(persona)
    }

    fun confirmarTour(tour: Tour) {
        confirmarObservers.forEach { it.confirmar(tour) }
    }

    fun agregarObserver(observer: ConfirmarObserver) {
        confirmarObservers.add(observer)
    }

}