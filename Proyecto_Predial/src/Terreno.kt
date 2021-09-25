class Terreno(var zona: IZona, var extension:Double){

    fun calcularCosto()= zona.costo*extension

}