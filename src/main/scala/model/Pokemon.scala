package model

case class Pokemon(val energia: Int,
              val fuerza: Int,
              val velocidad: Int,
              val especie: Especie,
              val experiencia: Int = 1,
              val nivel: Int = 1,
              val estado: Estado = Despierto){
  def this(especie:Especie) = this(especie.caracteristicas.energiaMaxima,especie.caracteristicas.fuerza,
                                   especie.caracteristicas.velocidad, especie)

  def descansar() = {
    copy(energia = especie.caracteristicas.energiaMaxima)
  }

  def nuevoEstado(nuevoEstado : Estado) = {
    copy(estado = nuevoEstado)
  }

  def perderEnergia(cant: Int) = {
    if (cant >= energia ){
      copy(energia = energia - cant)
    }
    else throw new SinEnergiaException("No tenes suficiente energia")
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

  def cansado() :Boolean = {
    energia < especie.caracteristicas.energiaMaxima/2
  }

  def evolucionar() = {
    val evolucion = especie.evolucion.get
    copy(energia = evolucion.caracteristicas.energiaMaxima, fuerza = evolucion.caracteristicas.fuerza,
      velocidad = evolucion.caracteristicas.velocidad, especie = evolucion)
  }
}

