import java.time.LocalDate

class Impuesto(persona: Persona) {
    val persona = persona

    var arrayTerrenos = arrayListOf<Terreno>()

    fun agregarTerreno(terreno: Terreno) {
        arrayTerrenos.add(terreno)
    }

    fun calcularImpuestoTotal(): Double {
        var resultado = 0.0
        arrayTerrenos.forEach { terreno ->
            resultado += terreno.calcularCosto()
        }
        return resultado
    }
    fun calcularTotal(): Double {//
        var mes = LocalDate.now().month.value
        var descuento = 0.0
        if (mes <= 2) {
            if (persona.calcularEdad() >= 70 || persona.madreSoltera.equals(true)) {
                descuento = 0.70

            } else {
                descuento = 0.40
            }
        } else if (persona.calcularEdad() >= 70 || persona.madreSoltera.equals(true)) {
            descuento = 0.50
        }
        var total = calcularImpuestoTotal()
        return (total - (total * descuento))
    }
}

