package model
import model.Actividades._

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
    actividad match {
      case (Descansar) => actividad(pokemon)
      case (_)         => pokemon.nuevoEstado(KO)
    }
  }
}

case class Dormido(var turnos : Int = 3) extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon ={
    if(turnos > 0){
      turnos -= 1
      pokemon
    }
    else {
      actividad(pokemon).nuevoEstado(Despierto)
    }
  }
}
case object KO extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon = {
    throw new EstadoKOException("No podes hacer nada, estas inconsciente")
  }
}
