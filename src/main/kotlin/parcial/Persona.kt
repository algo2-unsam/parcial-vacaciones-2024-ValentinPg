package parcial

//Punto 2
class Persona(var presupuesto: Double) {
    //Implemento un strategy, lo que me va a permitir cambiar facilmente la preferencia del Usuario
    lateinit var preferenciaVacaciones: PreferenciaVacaciones

    fun cambiarPreferenciaVacaciones(nuevaPreferencia: PreferenciaVacaciones) {
        preferenciaVacaciones = nuevaPreferencia
    }

    fun esLugarAdecuado(lugar: Lugar): Boolean = preferenciaVacaciones.esAdecuado(lugar)
}