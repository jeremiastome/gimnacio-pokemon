package test

import model._
import model.Actividades._
import org.scalatest.{BeforeAndAfter, FlatSpec}

class SubirNivelTest extends FlatSpec with BeforeAndAfter {
  var especie = new Especie(Agua, 20)
  var pokemon = new Pokemon(30, 100, 2, 5, especie)
  var gimnacio = new Gimnacio()

  "Si un pokemon necesita 20 puntos de experiencia para subir de nivel y llega a 11" should
      "no sube de nivel" in {
    assert(pokemon.nivel == 1)
    var res = gimnacio.realizarActividad(pokemon, LevantarPesas(10))
    assert(res.nivel == 1)
  }

  "Si un pokemon necesita 10 puntos de experiencia para subir de nivel y llega a 11" should
    "sube de nivel" in {
    var pokemon1 = new Pokemon(30, 100, 4, 5, new Especie(Agua, 10, Some(Pelea)))
    assert(pokemon.nivel == 1)
    var res = gimnacio.realizarActividad(pokemon1, LevantarPesas(10))
    assert(res.nivel == 2)
  }
}