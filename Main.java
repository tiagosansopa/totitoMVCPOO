public class Main {
    public static void main(String[] args) {

        TotitoController juego = new TotitoController("Jugador 1", 
                                                     "Jugador 2");

        juego.jugar(0, 0);
        juego.jugar(1, 0);
        juego.jugar(0, 1);
        juego.jugar(1, 2);
        juego.jugar(0, 2);
    }
}
