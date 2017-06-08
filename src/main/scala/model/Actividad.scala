package model

object Actividades{

  type Actividad = Int => Pokemon => Pokemon

  val Descansar : Pokemon => Pokemon = pokemon => pokemon.descansar()

  val LevantarPesas : Actividad = cant => pokemon => {
    (pokemon.especie, cant) match {
      case (_, kilos) if (kilos > 10 * pokemon.fuerza) => pokemon.perderEnergia(10)
      case (especie, _) if (especie.esTipo(Fantasma)) =>
        throw new NoPodesLevantarPesasException("El tipo fantasma no puede levantar pesas")
      case (especie, _) if (especie.esTipo(Pelea)) => pokemon.ganarExperiencia(cant * 2)
      case (_, _) => pokemon.ganarExperiencia(cant)
    }
  }

  val Nadar : Actividad = cant => pokemon => {
    pokemon.especie.tipos match {
      case(tipos) if(tipos.contains(Agua)) => pokemon.perderEnergia(cant).ganarExperiencia(200*cant).ganarVelocidad(cant/60)
      case(_) => pokemon.perderEnergia(cant).ganarExperiencia(200*cant)
    }
  }
}