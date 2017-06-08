package model

case class Pokemon(val energia: Int,
              val energiaMaxima: Int,
              val fuerza: Int,
              val velocidad: Int,
              val especie: Especie,
              val experiencia: Int = 1,
              val nivel: Int = 1,
              val estado: Estado = Despierto){

  def descansar() = {
    copy(energia = energiaMaxima)
  }

  def perderEnergia(cant: Int) = {
    copy(energia = energia - cant)
  }

  def ganarExperiencia(cant: Int) = {
    val nuevaExperiencia = experiencia + cant
    if(especie.puedeSubirNivel(nuevaExperiencia))
        copy(experiencia = nuevaExperiencia, nivel = nivel + 1)
    else copy(experiencia = nuevaExperiencia)
  }

  def ganarVelocidad(cant: Int) = {
    copy(velocidad = velocidad + cant)
  }
}

