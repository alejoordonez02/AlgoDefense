# TP2 - AlgoDefense
## Algoritmos y Programación 3
## Grupo11
* **108397 - Alejo Ordoñez** - [alejoordonez02](https://github.com/alejoordonez02)
* **109007 - Fernando Yu** - [fernandoyu](https://github.com/FernandoYu)
* **105414 - Gonzalo Olmos** - [gonzalo912](https://github.com/gonzalo912)
* **105801 - Lassalle Ezequiel** - [LassalleEzequiel](https://github.com/EzequielLassalle)
## Descripción del juego
El objetivo de este trabajo es el completo desarrollo de un Tower Defense, incluyendo el modelo de clases, sonidos e interfaz gráfica; acompañado por pruebas unitarias e integrales y documentación de diseño; utilizando el lenguaje Java, con un diseño orientado a objetos y trabajando con las técnicas de TDD e Integración Continua.
AlgoDefense es un Tower Defense pero no en tiempo real, sino por turnos. Es un juego de estrategia y se basa en la construcción de defensas que impidan que los enemigos lleguen hasta el jugador.
El plantel de enemigos se encuentra conformado por hormigas, arañas, topos y lechuzas, todos con habilidades únicas que requerirán diferentes estrategias para ser derrotados.
El jugador comienza con 20 puntos de vida y 100 créditos que le permitirán construir defensas, que irán retornando más créditos a medida que vayan eliminando enemigos según corresponda su unidad. A medida que los enemigos vayan llegando a la meta se le irán descontando puntos de vida al jugador y éste pierde la partida si llega a 0.
Las defensas que el jugador podrá utilizar para defenderse de las unidades enemigas son la Torre Blanca, de rápida construcción pero menos potente que la Torre Plateada, que a pesar de ser más cara y de tardar más en construirse es más fuerte. También se pueden construir Trampas Arenosas que ralentizan el avance de los enemigos cuando caen en ellas.
Como ya mencionamos el juego es por turnos, en cada uno de ellos las defensas atacaran según sus capacidades y el jugador elige si  quiero construir más o pasar.
La partida comienza con los enemigos apareciendo en el extremo inicial del mapa. Si el jugador logra sobrevivir cuando se hayan desfilado todos los enemigos, habrá ganado la partida.
## Herramientas de desarrollo
Para el desarrollo se usaron JDK, JavaFX, JUnit: framework de pruebas unitarias para Java, y Git para versionar el código y trabajar en conjunto.
Además utilizamos formas de desarrollo en grupo como aprendizaje cooperativo, evaluación grupal y "pair programming".
## Metodología de desarrollo
La realización de este trabajo consistió en 6 entregas semanales, en cada una de las cuáles recibimos una valoración sobre nuestro progreso por parte de nuestro corrector y consejos para seguir trabajando.
## Semana 1
- Planteo del modelo tentativo con diagramas de clases.
- Creación del repositorio de código.
- Configuración del servidor de integración continua.
- Commits de los integrantes.
## Semana 2
Implementación de la primera parte del modelo con sus respectivas pruebas unitarias e integrales sin interfaz gráfica.
## Semana 3
Implementación de la lectura de los archivos JSON con la configuración del juego.
## Semana 4
- Extensión del modelo y finalización del mismo, con todas sus pruebas.
- Implementación de la interfaz gráfica inicial.
## Semana 5
Implementación de la totalidad de la interfaz gráfica.
## Semana 6
Entrega final con el trabajo completo funcionando, con interfaz gráfica y sonidos.
## Desarrollo
<!-- ## Supuestos -->
<!-- Diagramas de clases -->
<!-- Diagramas de secuencia -->
<!-- Diagrama de paquetes -->
<!-- Diagramas de estado -->
## Detalles de implementación
Para la implementación fuimos cuidadosos con los pilares de la programación orientada a objetos. Además aplicamos algunos de sus principios, como "Tell Don't Ask", Ley de Demeter, Programación contra Interfaces, entre otras.
También hicimos uso del patrón de diseño "Strategy" para la implementación de la movilidad de los enemigos. Esto nos permitió no repetir código y lograr una solución mucho más robusta y de fácil extensión.
## Excepciones
- ParcelaInvalida: se lanza cuando se quiere construir una defensa en un terreno en el cuál no se puede edificar.
- CreditosInsuficientes: como indica su nombre, salta cuando los créditos del jugador no alcanzan para construir una defensa determinada.


