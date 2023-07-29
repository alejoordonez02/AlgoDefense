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
![JuegoJugadorYMapa](diagramas/clases/JuegoJugadorYMapa.png)
### Defensas
![Defensas](diagramas/clases/Defensas.png)
### Defensas y Parcelas
![Defensas y Parcelas](diagramas/clases/DefensasYParcelas.png)
### Herencia Enemigos
![Herencia Enemigos](diagramas/clases/HerenciaEnemigos.png)
### Movedor con Strategy
![Movedor con Strategy](diagramas/clases/MovedorConStrategy.png)

## Diagramas de secuencia
### Inicialización
![Inicialización](diagramas/secuencia/inicializacion.png)
### Torre usando Rango para atacar
![Torre usando Rango para atacar](diagramas/secuencia/caso1.png)
### Trampa Arenosa ralentizando enemigos
![Trampa Arenosa ralentizando enemigos](diagramas/secuencia/caso2.png)
### Enemigos moviéndose y atacando
![Enemigos moviéndose y atacando](diagramas/secuencia/enemigosMoviendoseYAtacando.png)

## Diagrama de paquetes
### Paquetes
![Paquetes](diagramas/paquetes/paquetes.png)
### Modelo-vista-controlador
![Modelo-vista-controlador](diagramas/paquetes/diagramaMVC.png)

## Diagramas de estado
### Torre pasa a estar operativa
![Torre pasa a estar operativa](diagramas/estados/diagramaTorreOperativa.png)
### Enemigo pasa a estar ralentizado
![Enemigo pasa a estar ralentizado](diagramas/estados/diagramaRalentizacion.png)

## Detalles de implementación
Para el desarrollo de la aplicación fuimos cuidadosos con los pilares de la programación orientada a objetos. Aplicamos algunos de sus principios, como "Tell Don't Ask", Ley de Demeter, Programación contra Interfaces, entre otros.
Hicimos uso del patrón de diseño "Strategy" para la implementación de la movilidad de los enemigos. Esto nos permitió no repetir código y lograr una solución mucho más robusta y de fácil extensión.
También usamos el patrón "Modelo-vista-controlador" para separar el código según su responsabilidad.

## Excepciones
- ParcelaInvalida: se lanza cuando se quiere construir una defensa en un terreno en el cuál no se puede edificar.
- CreditosInsuficientes: salta cuando los créditos del jugador no alcanzan para construir una defensa determinada.
- JSONVacio: se arroja cada vez que se quiere parsear un JSON que está vacío
- FormatoJSONINvalido: si el formato del JSON que se intenta parsear no es el correcto se arroja esta excepción