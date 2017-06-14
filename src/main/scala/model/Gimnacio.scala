package model

class Gimnacio {
  def realizarActividad(pokemon: Pokemon, actividad: (Pokemon => Pokemon)) : Pokemon = {
    pokemon.estado.realizarActividad(pokemon, actividad)
  }

  def realizarRutina(pokemon: Pokemon, rutina: List[(Pokemon => Pokemon)]) : Pokemon = {
    rutina.foldLeft(pokemon)((res , f) => {
      try{
        realizarActividad(res, f)
      }
      catch{
          case error: RuntimeException => throw new RutinaException(
            "No podes realizar la actividad numero "+rutina.indexOf(f))
        }
    })
  }
}
