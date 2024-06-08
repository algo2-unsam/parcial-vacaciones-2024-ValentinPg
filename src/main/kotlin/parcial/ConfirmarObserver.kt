package parcial

interface ConfirmarObserver {
    fun confirmar(tour: Tour)
}

class EnviarMailObs(val mailSender: MailSender) : ConfirmarObserver {
    override fun confirmar(tour: Tour) {
        tour.personasABordo.forEach { mailSender.sendEmail(armarMail(tour, it.email)) }
    }

    private fun armarMail(tour: Tour, casillaDestino: String): Mail {
        return Mail(
            from = "AdminTours@gmail.com",
            to = casillaDestino,
            subject = "Todo Ready!",
            // falta hacer un max de la fecha de salida minus 30 con LocalDate.now()
            content = """"fecha de Salida: ${tour.fechaSalida}
                fecha limite de pago: ${tour.fechaSalida.minusDays(30)}
                Lugares a visitar: ${tour.lugaresARecorrer.joinToString()}""".trimMargin()
        )
    }
}

class MailSender {
    fun sendEmail(mail: Mail) {}
}

data class Mail(val from: String, val to: String, val subject: String, val content: String)

class AlarmaAfipObs : ConfirmarObserver {
    val MONTO_MINIMO_ALARMA = 10000000.0
    override fun confirmar(tour: Tour) {
        if (tour.montoXPersona > MONTO_MINIMO_ALARMA) {
            activarAlarma(tour)
        }
    }

    private fun activarAlarma(tour: Tour) {
        Afip.recibirAviso(tour.codigosDeLugares(), tour.dniPersonas())
    }
}

object Afip {
    fun recibirAviso(codigos: List<Int>, dniPersona: List<Int>) {}
}

//Fuerzo el cambio de estado en los que tienen preferencia Alternador
class AlternadorObs : ConfirmarObserver {
    override fun confirmar(tour: Tour) {
        val lugarStub = Ciudad(nombre = "Lugar Stub", cantidadDecibeles = 0.0, cantidadHabitantes = 0, codigoAfip = 0)
        tour.personasABordo.forEach { it.esLugarAdecuado(lugarStub) }
    }
}
