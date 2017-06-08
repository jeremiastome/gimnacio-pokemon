package model

abstract class Tipo(val debilidad: Tipo = null)

case object Agua extends Tipo(Planta)
case object Fuego extends Tipo(Agua)
case object Electrico extends Tipo(Roca)
case object Planta extends Tipo(Fuego)
case object Roca extends Tipo(Agua)
case object Pelea extends Tipo(Psiquico)
case object Fantasma extends Tipo
case object Psiquico extends Tipo(Fantasma)