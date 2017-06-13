package model

import model.Estados._

object Actividades{

  type Actividad = Pokemon => Pokemon

  val Descansar : Pokemon => Pokemon = pokemon => pokemon.descansar()

  val LevantarPesas : Int => Actividad = cant => pokemon => {
    val esp = pokemon.especie
    (esp.tipoPrincipal, esp.tipoSecundario , cant) match {
      case (_, _, kilos) if (kilos > 10 * pokemon.fuerza) => pokemon.perderEnergia(10).nuevoEstado(Paralizado)
      case (Fantasma, _, _) => throw new NoPodesLevantarPesasException("El tipo fantasma no puede levantar pesas")
      case (_, Some(Fantasma), _) => throw new NoPodesLevantarPesasException("El tipo fantasma no puede levantar pesas")
      case (Pelea, _, _) => pokemon.ganarExperiencia(cant * 2)
      case (_, Some(Pelea), _) => pokemon.ganarExperiencia(cant * 2)
      case (_, _, _) => pokemon.ganarExperiencia(cant)
    }
  }

  val Nadar : Int => Actividad = cant => pokemon => {
    val esp = pokemon.especie
    (esp.tipoPrincipal, esp.tipoSecundario) match {
      case (Agua, _) => pokemon.perderEnergia(cant).ganarExperiencia(200*cant).ganarVelocidad(cant/60)
      case (_, Some(Agua)) => pokemon.perderEnergia(cant).ganarExperiencia(200*cant).ganarVelocidad(cant/60)
      case(_, _) => pokemon.perderEnergia(cant).ganarExperiencia(200*cant)
    }
  }
}