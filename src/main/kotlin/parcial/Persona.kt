package parcial

//Punto 2
class Persona {
    //Implemento un strategy, lo que me va a permitir cambiar facilmente la preferencia del Usuario
    lateinit var preferenciaVacaciones: PreferenciaVacaciones

    fun cambiarPreferenciaVacaciones(nuevaPreferencia: PreferenciaVacaciones) {
        preferenciaVacaciones = nuevaPreferencia
    }
}