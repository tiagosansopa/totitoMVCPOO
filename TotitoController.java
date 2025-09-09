public class TotitoController {

    public static class PosicionFueraDeTableroException extends Exception {
        public PosicionFueraDeTableroException(String mensaje) {
            super(mensaje);
        }
    }

    public static class PosicionOcupadaException extends Exception {
        public PosicionOcupadaException(String mensaje) {
            super(mensaje);
        }
    }

    public Tablero tablero;
    public Jugador jugador1;
    public Jugador jugador2;
    public Jugador jugadorActual;

    public TotitoController(String nombreJugador1, String nombreJugador2) {
        tablero = new Tablero();
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);
        jugadorActual = jugador1;
    }



    public void jugar(int fila, int columna) {
        try {
            if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                throw new PosicionFueraDeTableroException("La posición está fuera del tablero 3x3.");
            }
            if (tablero.obtenerPieza(fila, columna) != null) {
                throw new PosicionOcupadaException("La posición ya está ocupada.");
            }
            String pieza = jugadorActual == jugador1 ? "X" : "O";
            tablero.colocarPieza(fila, columna, pieza);

            validar(pieza);

        } catch (PosicionFueraDeTableroException | PosicionOcupadaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validar(String pieza) {
    if (verificarGanador(pieza)) {
        System.out.println(jugadorActual.getNombre() + " gana!");
        jugadorActual.incrementarPuntaje(1);
        tablero.mostrarTablero();
        System.out.println("Puntajes: " + jugador1.getNombre() + ": " + jugador1.getPuntaje() + ", " + jugador2.getNombre() + ": " + jugador2.getPuntaje());
               
    } else if (esEmpate()) {
        System.out.println("Empate!");
        tablero.mostrarTablero();
    }
       
     else {
        cambiarTurno();
    }
    }



    public boolean verificarGanador(String pieza) {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((tablero.obtenerPieza(i, 0) != null && tablero.obtenerPieza(i, 0).equals(pieza) &&
                 tablero.obtenerPieza(i, 1) != null && tablero.obtenerPieza(i, 1).equals(pieza) &&
                 tablero.obtenerPieza(i, 2) != null && tablero.obtenerPieza(i, 2).equals(pieza)) ||
                (tablero.obtenerPieza(0, i) != null && tablero.obtenerPieza(0, i).equals(pieza) &&
                 tablero.obtenerPieza(1, i) != null && tablero.obtenerPieza(1, i).equals(pieza) &&
                 tablero.obtenerPieza(2, i) != null && tablero.obtenerPieza(2, i).equals(pieza))) {
                return true;
            }
        }
        // Verificar diagonales
        if ((tablero.obtenerPieza(0, 0) != null && tablero.obtenerPieza(0, 0).equals(pieza) &&
             tablero.obtenerPieza(1, 1) != null && tablero.obtenerPieza(1, 1).equals(pieza) &&
             tablero.obtenerPieza(2, 2) != null && tablero.obtenerPieza(2, 2).equals(pieza)) ||
            (tablero.obtenerPieza(0, 2) != null && tablero.obtenerPieza(0, 2).equals(pieza) &&
             tablero.obtenerPieza(1, 1) != null && tablero.obtenerPieza(1, 1).equals(pieza) &&
             tablero.obtenerPieza(2, 0) != null && tablero.obtenerPieza(2, 0).equals(pieza))) {
            return true;
        }
        return false;
    }

    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero.obtenerPieza(i, j) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void cambiarTurno() {
        System.out.println("Turno actual: " + jugadorActual.getNombre());
        if (jugadorActual == jugador1) {
            jugadorActual = jugador2;
        } else {
            jugadorActual = jugador1;
        }
        System.out.println("Turno cambiado a: " + jugadorActual.getNombre());
    }

}
