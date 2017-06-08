package test

import model.Actividades._
import model._
import org.scalatest.{BeforeAndAfter, FlatSpec}

class ActividadTest extends FlatSpec with BeforeAndAfter{
  var especie = new Especie(Agua, Psiquico, 100)
  var pokemon = new Pokemon(30, 100, 2, 5, especie)
  var gimnacio = new Gimnacio()

  "Un pokemon con energia maxima 100 que descansa" should "tener su energia en 100" in {
    assert(pokemon.energia == 30)
    var res = gimnacio.realizarActividad(pokemon, Descansar)
    assert(res.energia == 100)
  }

  "Un pokemon con 1 de experiencia despues de levantar pesas de 10 kilos" should "tener su experiencia en 11" in {
    assert(pokemon.experiencia == 1)
    var res = gimnacio.realizarActividad(pokemon, LevantarPesas(10))
    assert(res.experiencia == 11)
  }

  "Un pokemon tipo pelea con 1 de experiencia despues de levantar pesas de 2 kilos" should "tener su experiencia en 5" in {
    var pokemon1 = new Pokemon(30, 100, 4, 5, new Especie(Pelea, Agua, 100))
    var res = gimnacio.realizarActividad(pokemon1, LevantarPesas(2))
    assert(res.experiencia == 5)
  }

  "Un pokemon tipo fantasma" should "no puede levantar pesas" in {
    assertThrows[NoPodesLevantarPesasException] {
      var pokemon2 = new Pokemon(30, 100, 4, 5, new Especie(Fantasma, Psiquico, 100))
      var res = gimnacio.realizarActividad(pokemon2, LevantarPesas(2))
    }
  }

  "Un pokemon con 2 de furza y 30 de energia despues de levantar pesas de 25 kilos" should "tener su energia en 20" in {
    assert(pokemon.energia == 30)
    var res = gimnacio.realizarActividad(pokemon, LevantarPesas(25))
    assert(res.energia == 20)
  }

  "Un pokemon con 30 de energia y 1 de experiencia  despues de nadar 5 minutos" should
          "tener su energia en 25 y su experiencia en 1001" in {
    var res = gimnacio.realizarActividad(pokemon, Nadar(5))
    assert(res.energia == 25)
    assert(res.experiencia == 1001)
  }

  "Un pokemon tipo agua con 70 de energia, 1 de experiencia y 5 de velocidad despues de nadar una hora" should
    "tener su energia en 10, su experiencia en 12001 y su velocidad en 6" in {
    var pokemon3 = new Pokemon(70, 100, 4, 5, new Especie(Agua, Psiquico, 100))
    var res = gimnacio.realizarActividad(pokemon3, Nadar(60))
    assert(res.energia == 10)
    assert(res.experiencia == 12001)
    assert(res.velocidad == 6)
  }
}
