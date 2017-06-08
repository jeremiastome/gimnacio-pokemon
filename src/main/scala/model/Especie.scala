package model

class Especie(val tipoPrincipal: Tipo,
              val tipoSecundario: Tipo,
              val resistenciaEvolutiva: Int,
              var experienciaProximoNivel: Int = 0) {

  def tipos(): List[Tipo] ={
    val tipos : List[Tipo] = List(tipoPrincipal, tipoSecundario)
    return tipos
  }

  def esTipo(tipo: Tipo): Boolean = {
    tipos().contains(tipo)
  }

  def puedeSubirNivel(experiencia: Int): Boolean ={
    experiencia >= experienciaProximoNivel + resistenciaEvolutiva
  }

  def setExperienciaProximoNivel(experiencia: Int): Unit ={
    experienciaProximoNivel = 2 * experienciaProximoNivel
  }
}
