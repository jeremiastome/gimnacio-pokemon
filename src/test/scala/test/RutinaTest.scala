package test

import model.{Especie, _}
import model.Actividades._
import org.scalatest.{BeforeAndAfter, FlatSpec}

class RutinaTest extends FlatSpec with BeforeAndAfter {
  var especie = new Especie(Agua, 20, new Caracteriasticas(30, 100, 2, 5))
  var pokemon = new Pokemon(especie)
  var gimnacio = new Gimnacio()

  "Un pokemon con 1 de experiencia despues realizar una rutina con solo la actividad de levantar pesas de 10 kilos" should
    "tener su experiencia en 11"  in {
      var res = gimnacio.realizarRutina(pokemon, List(LevantarPesas(10)))
      assert(res.experiencia == 11)
  }

  "Un pokemon tipo despues realizar una rutina donde nada" should "su estado es KO"  in {
    var pokemonFuego = new Pokemon(new Especie(Fuego, 20, new Caracteriasticas(30, 100, 2, 5)))
    var res = gimnacio.realizarRutina(pokemonFuego, List(LevantarPesas(10), Nadar(4)))
    assert(res.experiencia == 11)
    assert(res.estado == KO)
  }

  "Un pokemon dormido luego de una rutina de dos actividades " should "seguir dormido"  in {
    var pokemonDormido = (new Pokemon(new Especie(Fuego, 20, new Caracteriasticas(30, 100, 2, 5)))).nuevoEstado(new Dormido())
    var res = gimnacio.realizarRutina(pokemonDormido, List(LevantarPesas(10), Nadar(4)))
    assert(res.experiencia == 1)
    assert(res.estado == Dormido(1))
  }

  "Un pokemon dormido luego de una rutina de tres actividades " should " se despierta"  in {
    var pokemonDormido = (new Pokemon(new Especie(Fuego, 20, new Caracteriasticas(30, 100, 2, 5)))).nuevoEstado(new Dormido())
    var res = gimnacio.realizarRutina(pokemonDormido, List(LevantarPesas(10), Nadar(4), LevantarPesas(12)))
    assert(res.experiencia == 1)
    assert(res.estado == Despierto)
  }

  "Si un pokemon fantasma quiere realizar una rutina donde incluya levantar pesas" should " no deberia poder"  in {
    var pokemonDormido = new Pokemon(new Especie(Fuego, 20, new Caracteriasticas(30, 100, 2, 5), Some(Fantasma)))
    intercept[RutinaException]{
      gimnacio.realizarRutina(pokemonDormido, List(Nadar(4), LevantarPesas(12)))
    }
  }
}