import java.time.LocalDate
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit

class Reporte(personal: Personal, registros: List<Registro>, horarios: List<Horario>) {

    public var retardos = 0
    public var faltas = 0
    public var permisos = 0
    val personal = personal
    private val registros = registros
    private val horarios = horarios
    private var retardosQuincena = 0
    constructor(personal: Personal, registros: List<Registro>, horarios: List<Horario>,fechaInicial: String, fechaFinal: String ) : this(personal,registros,horarios) {
        generarReporte(fechaInicial,fechaFinal)
    }

    fun generarReporte(fechaInicial: String, fechaFinal: String): Reporte {
        var fechaActual: LocalDate = LocalDate.parse(fechaInicial)
        var fin: LocalDate = LocalDate.parse(fechaFinal)

        //loop que se ejecuta mientras el dia actual sea menor que la fecha final
        while (!fechaActual.isAfter(fin)) {
            var diaActual = fechaActual.dayOfWeek
            if (esQuincena(fechaActual))
                reiniciarRetardosPorQuincena()
            horarios.forEach { horario ->
                if (horario.dia == diaActual ){
                    var retardo = calcularRetardo( fechaActual, horario)
                    calcularFalta(fechaActual, horario, retardo)
                }
            }
            fechaActual = fechaActual.plusDays(1)

        }
        return this

    }

    fun calcularRetardo(diaActual: LocalDate, horario: Horario): Boolean {
        val registro = obtenerRegistro(diaActual)
        if (registro != null) {
            var llegada = registro.rangoHora.horaInicial.minus(
                horario.rangoHora.horaInicial.getLong(ChronoField.MINUTE_OF_DAY),
                ChronoUnit.MINUTES)
            if (llegada.minute in 5..15){
                retardos++
                retardosQuincena++
                return true
            }
        }
        return false

    }

    fun calcularFalta(diaActual: LocalDate, horario: Horario, retardo: Boolean): Boolean {

        val registro = obtenerRegistro(diaActual)
        if (registro == null) {

            faltas++
            return true
        }
        if (personal.calcularAntigüedad() > 10)
            return false
        if (registro.rangoHora.horaFinal.isBefore(horario.rangoHora.horaFinal) || retardo && retardosQuincena % 3 == 0) {
            faltas++
            return true
        }
        return false
    }

    private fun obtenerRegistro(diaActual: LocalDate): Registro? {
        return registros.find { registro -> registro.fecha == diaActual }
    }


    private fun esQuincena(diaActual: LocalDate): Boolean{
        return  diaActual.dayOfMonth == 15 || diaActual.minusDays(1).month > diaActual.month

    }

    private fun reiniciarRetardosPorQuincena() {
        retardosQuincena = 0
    }
}






