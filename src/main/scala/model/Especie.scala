package model

class Especie(val tipoPrincipal: Tipo,
              val resistenciaEvolutiva: Int,
              val caracteristicas: Caracteriasticas,
              val tipoSecundario: Option[Tipo] = None,
              val evolucion: Option[Especie] = None,
              val condicion: Option[Condicion] = None,
              var experienciaProximoNivel: Int = 0) {

  def debilidades(): List[Tipo] ={
    (tipoSecundario) match {
      case (Some(_)) => List(tipoPrincipal.debilidad, tipoSecundario.get.debilidad)
      case (None) => List(tipoPrincipal.debilidad)
    }
  }

  def puedeSubirNivel(experiencia: Int): Boolean ={
    experiencia >= experienciaProximoNivel + resistenciaEvolutiva
  }

  def setExperienciaProximoNivel(experiencia: Int): Unit ={
    experienciaProximoNivel = 2 * experienciaProximoNivel
  }
}

class Caracteriasticas(val energia: Int,
                       val energiaMaxima: Int,
                       val fuerza: Int,
                       val velocidad: Int)
