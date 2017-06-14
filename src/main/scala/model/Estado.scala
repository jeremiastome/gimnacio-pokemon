package model
import model.Actividades._

abstract class Estado() {
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon
}

case object Despierto extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon ={
    (actividad) match {
      case (Nadar) if (pokemon.especie.debilidades.contains(Agua)) => pokemon.nuevoEstado(KO)
      case (Descansar) if pokemon.cansado => actividad(pokemon).nuevoEstado(new Dormido())
      case (_) => actividad(pokemon)
    }
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
    if(turnos > 1){
      pokemon.copy(estado = new Dormido(turnos - 1))
    }
    else {
      pokemon.nuevoEstado(Despierto)
    }
  }
}
case object KO extends Estado{
  def realizarActividad(pokemon: Pokemon, actividad : (Pokemon => Pokemon)): Pokemon = {
    throw new EstadoKOException("No podes hacer nada, estas inconsciente")
  }
}
