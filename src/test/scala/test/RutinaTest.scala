package test

import model._
import model.Actividades._
import org.scalatest.{BeforeAndAfter, FlatSpec}

class RutinaTest extends FlatSpec with BeforeAndAfter {
  var especie = new Especie(Agua, 20)
  var pokemon = new Pokemon(30, 100, 2, 5, especie)
  var gimnacio = new Gimnacio()

  "Un pokemon con 1 de experiencia despues realizar una rutina con solo la actividad de levantar pesas de 10 kilos" should
    "tener su experiencia en 11"  in {
      var res = gimnacio.realizarRutina(pokemon, List(LevantarPesas(10)))
      assert(res.experiencia == 11)
  }
}