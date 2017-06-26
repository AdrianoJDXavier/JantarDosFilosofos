package jantar_filosofo;

/**
 *
 * @author Adriano
 */
public class JantarDosFilosofos {

// Number of filosofos
    final static int n = 5;

    final static Filosofo[] filosofos = new Filosofo[n];
    final static Garfos[] garfo = new Garfos[n];

    public static void main(String[] args) {

        // Inicializar objetos compartilhados
        for (int i = 0; i < n; i++) {
            garfo[i] = new Garfos();
        }

    // Inicializa threads
        // make first philosopher left-handed and all others right-handed
        filosofos[0] = new Filosofo(0, garfo[1], garfo[0]);
        for (int i = 1; i < n; i++) {
            filosofos[i] = new Filosofo(i, garfo[i], garfo[(i + 1) % n]);
        }

        // Start the threads
        for (int i = 0; i < filosofos.length; i++) {
            Thread t = filosofos[i];
            t.start();
        }
    }
}
