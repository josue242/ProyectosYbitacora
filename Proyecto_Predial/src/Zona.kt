class zonaRural() : IZona {
    override var clave: String = "RUR"
    override var descripcion = "Rural"
    override var costo=8.0
}

class zonaUrbana() : IZona {
    override var clave: String = "URB"
    override var descripcion = "Urbana"
    override var costo=10.0
}

class zonaMarginada() : IZona {
    override var clave: String = "MAR"
    override var descripcion = "Marginada"
    override var costo=2.0
}

class zonaResidencial() : IZona {
    override var clave: String = "RES"
    override var descripcion = "Residencial"
    override var costo=25.0
}
