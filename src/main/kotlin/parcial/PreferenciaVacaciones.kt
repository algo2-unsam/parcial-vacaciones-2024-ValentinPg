package parcial

//Punto 2
//Utilizo una interfaz ya que es stateless
interface PreferenciaVacaciones {
    fun esAdecuado(lugar: Lugar): Boolean
}

class LugarTranquilo : PreferenciaVacaciones {
    override fun esAdecuado(lugar: Lugar): Boolean = lugar.esTranquilo()
}

class LugarDivertido : PreferenciaVacaciones {
    override fun esAdecuado(lugar: Lugar): Boolean = lugar.esDivertido()
}

class Alternador() : PreferenciaVacaciones {
    var alternador: Boolean = true
    override fun esAdecuado(lugar: Lugar): Boolean {
        alternador = !alternador
        if (alternador) return LugarTranquilo().esAdecuado(lugar) else return LugarDivertido().esAdecuado(lugar)
    }
}

//Acá utilizo un composite ya que anido Preferencias dentro de preferencias
class Combinador(val preferencias: List<PreferenciaVacaciones>) : PreferenciaVacaciones {
    override fun esAdecuado(lugar: Lugar): Boolean = preferencias.any { it.esAdecuado(lugar) }
}