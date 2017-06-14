package model

trait Tipo {
  def debilidad: Tipo = null
}

case object Agua extends Tipo {
  override def debilidad = Planta
}
case object Fuego extends Tipo {
  override def debilidad = Agua
}
case object Electrico extends Tipo {
  override def debilidad = Roca
}
case object Planta extends Tipo {
  override def debilidad = Fuego
}
case object Roca extends Tipo {
  override def debilidad = Agua
}
case object Pelea extends Tipo {
  override def debilidad = Psiquico
}
case object Fantasma extends Tipo {
  override def debilidad = Roca
}
case object Psiquico extends Tipo {
  override def debilidad = Fantasma
}
case object Volador extends Tipo {
  override def debilidad = Electrico
}