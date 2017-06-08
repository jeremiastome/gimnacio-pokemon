package model

class Gimnacio {
  def realizarActividad(pokemon: Pokemon, actividad: (Pokemon => Pokemon)) : Pokemon = {
    actividad(pokemon)
    //  pokemon.estado.realizarActividad(pokemon, actividad)
  }

  def realizarRutina(pokemon: Pokemon, rutina: List[(Pokemon => Pokemon)]) : Pokemon = {
    rutina.foldLeft(pokemon)((res , f) => realizarActividad(res, f))
  }
}
