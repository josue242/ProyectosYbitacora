import org.junit.Test
import kotlin.collections.ArrayList
import java.time.LocalDate


data class Persona(val nombre: String, var fechaNacimiento: LocalDate, val madreSoltera: Boolean) {

    fun calcularEdad() = LocalDate.now().year - fechaNacimiento.year
}



