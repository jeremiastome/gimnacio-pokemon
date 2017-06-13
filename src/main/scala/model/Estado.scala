package model
import model.Actividades._

object Estados {

  type Estado = Pokemon => Actividad => Pokemon

  val Descansar: Pokemon => Pokemon = pokemon => pokemon.descansar()

  val Despierto : Estado = pokemon => actividad => {
    (actividad) match {
      case (Nadar) if (pokemon.especie.debilidades.contains(Agua)) => pokemon.nuevoEstado(KO)
      case (Descansar) if pokemon.cansado => actividad(pokemon).nuevoEstado(Dormido(3))
      case (_) => actividad(pokemon)
    }
  }

  val Paralizado : Estado = pokemon => actividad => {
    actividad match {
      case (Descansar) => actividad(pokemon)
      case (_)         => pokemon.nuevoEstado(KO)
    }
  }

  val Dormido : Int => Estado = turnos => pokemon => actividad => {
    if(turnos > 0){
      pokemon.copy(estado = Dormido(turnos - 1))
    }
    else {
      actividad(pokemon.nuevoEstado(Despierto))
    }
  }

  val KO : Estado = pokemon => actividad => {
    throw new EstadoKOException("No podes hacer nada, estas inconsciente")
  }
}
