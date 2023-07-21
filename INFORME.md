# TP2 - AlgoDefense
## Algoritmos y Programación 3
## Grupo11
* **108397 - Alejo Ordoñez** - [alejoordonez02](https://github.com/alejoordonez02)
* **109007 - Fernando Yu** - [fernandoyu](https://github.com/FernandoYu)
* **105414 - Gonzalo Olmos** - [gonzalo912](https://github.com/gonzalo912)
## Supuestos
- Cuando muere una lechuza retorna 5 créditos
## Diagramas de clases
### Juego Jugador y Mapa
![JuegoJugadorYMapa](diagrams/modelo/JuegoJugadorYMapa.png)
### Defensas
![Defensas](diagrams/modelo/Defensas.png)
### Defensas y Parcelas
![Defensas y Parcelas](diagrams/modelo/DefensasYParcelas.png)
### Herencia Enemigos
![Herencia Enemigos](diagrams/modelo/HerenciaEnemigos.png)
### Movedor con Strategy
![Movedor con Strategy](diagrams/modelo/MovedorConStrategy.png)

## Diagramas de secuencia
### Inicialización
![Inicialización](diagrams/secuencia/inicializacion.png)
### Torre usando Rango para atacar
![Torre usando Rango para atacar](diagrams/secuencia/caso1.png)
### Trampa Arenosa ralentizando enemigos
![Trampa Arenosa ralentizando enemigos](diagrams/secuencia/caso2.png)
### Enemigos moviéndose y atacando
![Enemigos moviéndose y atacando](diagrams/secuencia/enemigosMoviendoseYAtacando.png)

## Diagrama de paquetes
### Paquetes
![Paquetes](diagrams/paquetes/paquetes.png)

## Diagramas de estado
## Detalles de implementación
Para la implementación fuimos cuidadosos con los pilares de la programación orientada a objetos. Además aplicamos algunos de sus principios, como "Tell Don't Ask", Ley de Demeter, Programación contra Interfaces, entre otras.
También hicimos uso del patrón de diseño "Strategy" para la implementación de la movilidad de los enemigos. Esto nos permitió no repetir código y lograr una solución mucho más robusta y de fácil extensión.
## Excepciones
- ParcelaInvalida: se lanza cuando se quiere construir una defensa en un terreno en el cuál no se puede edificar.
- CreditosInsuficientes: salta cuando los créditos del jugador no alcanzan para construir una defensa determinada.
- JSONVacio: se arroja cada vez que se quiere parsear un JSON que está vacío
- FormatoJSONINvalido: si el formato del JSON que se intenta parsear no es el correcto se arroja esta excepción


