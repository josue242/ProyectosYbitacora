import java.time.LocalDate

class Registro (val personal: Personal, fecha: String,
                val rangoHora: RangoHora
){
    val fecha: LocalDate = LocalDate.parse(fecha)

}