# Totito – MVC Java

Una implementación sencilla de **Totito** en Java siguiendo la arquitectura **Model-View-Controller (MVC)**.  

Aqui demostramos la separación clara entre lógica del juego, interfaz de usuario y control de flujo en una aplicación pequeña.

Inicialmente solamente tenemos un controlador, modelos y manejamos la interaccion con el usuario en la clase principal.

## Cómo está estructurado
- **Model**:
   -- Tablero.java Almacena el tablero y podemos realizar movimientos.
   -- Jugador.java Almacena al usuario y su puntuacion

- **Controller**:
   -- TotitoController.java Administra los turnos de los jugadores, conecta el modelo y la vista, y controla el flujo del juego.
  
- **View**: Se encargara de mostrar el tablero y mensajes del juego _pendiente de implementar_.  

## Funcionamiento
- Dos jugadores se turnan para colocar X y O en un tablero 3×3.

- Gana el jugador que logre alinear tres de sus pirzas en fila, columna o diagonal.

- Si el tablero se llena sin un ganador, el juego termina en empate.

## Cuales conceptos estamos practicando 

- Patrón MVC: Separación clara de responsabilidades.

- Progra Orientada a Objetos: Encapsulación de la lógica del juego en cada clase.

- Interacción por consola _(o Swing/JavaFX cuando implemente el GUI)_.
