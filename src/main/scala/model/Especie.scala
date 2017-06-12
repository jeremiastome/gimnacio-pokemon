package model

class Especie(val tipoPrincipal: Tipo,
              val resistenciaEvolutiva: Int,
              val tipoSecundario: Option[Tipo] = None,
              var experienciaProximoNivel: Int = 0) {

  def puedeSubirNivel(experiencia: Int): Boolean ={
    experiencia >= experienciaProximoNivel + resistenciaEvolutiva
  }

  def setExperienciaProximoNivel(experiencia: Int): Unit ={
    experienciaProximoNivel = 2 * experienciaProximoNivel
  }
}
