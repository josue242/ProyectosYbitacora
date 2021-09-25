import java.time.LocalDate

data class Personal(var id_Personal: Int,  var nombre: String, var curp: String, var fecha_Ingreso:
    LocalDate, var genero: String, var gradoAcademico: GradoAcademico, var  clavePresupuestal: String
    ) {

    fun calcularAntigüedad() =LocalDate.now().year-fecha_Ingreso.year


}

