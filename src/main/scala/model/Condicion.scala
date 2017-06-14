package model

abstract class Condicion extends (Pokemon => Pokemon){
}

case class SubirNivel(nivel:Int) extends Condicion{
  def apply(pokemon: Pokemon): Pokemon ={
    pokemon.evolucionar()
  }
}

case class Intercambiar() extends Condicion{
  def apply(pokemon: Pokemon): Pokemon ={
    pokemon.especie.condicion.get match {
      case Intercambiar() => pokemon.evolucionar()
      case _ => pokemon.copy()
    }
  }
}

case class UsarPiedra(piedra: PiedraEvolutiva) extends Condicion{
  def apply(pokemon: Pokemon): Pokemon ={
    (pokemon.especie.tipoPrincipal, pokemon.especie.condicion.get)  match {
      case (piedra.tipoEspecie, UsarPiedra(piedra)) => pokemon.evolucionar()
      case (_, _) => pokemon.copy()
    }
  }
}

abstract class PiedraEvolutiva(val tipoEspecie: Tipo)
