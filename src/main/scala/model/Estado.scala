package model

abstract class Estado() {
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon
}

case object Despierto extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon ={
    actividad (pokemon)

    }
}

case object Paralizado extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon ={
    actividad(pokemon)
  }
}
case object Dormido extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon ={
    actividad(pokemon)
  }
}
case object KO extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon ={
    actividad(pokemon)
  }
}
