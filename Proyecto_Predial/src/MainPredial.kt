import org.junit.Test
import java.time.LocalDate

class MainPredial {
    @Test
    fun main() {
        val propietario = Persona("Pedro", fechaNacimiento = LocalDate.of(1998,2,
            11),madreSoltera = false)
        val impuesto = Impuesto(propietario)
        impuesto.agregarTerreno(Terreno(zonaResidencial(), extension = 800.0))
        impuesto.agregarTerreno(Terreno(zonaUrbana(), extension = 600.0))

        println("Total sin descuento:"+impuesto.calcularImpuestoTotal())
        println("Total :"+impuesto.calcularTotal())
    }
}





