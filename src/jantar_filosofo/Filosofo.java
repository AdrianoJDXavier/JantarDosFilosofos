package jantar_filosofo;


public class Filosofo extends Thread {

    private enum Estado {

        PENSANDO, FAMINTO, COMENDO
    };

    private int id;
    private Garfos primeiroGarfo;
    private Garfos segundoGarfo;
    private Estado estado;

    Filosofo(int id, Garfos fst, Garfos snd) {
        this.id = id;
        primeiroGarfo = fst;
        segundoGarfo = snd;
        estado = Estado.PENSANDO;
    }

    public void run() {
        while (true) {
            imprimeEstado();
            switch (estado) {
                case PENSANDO:
                    PenseOuComa();
                    estado = Estado.FAMINTO;
                    break;
                case FAMINTO:
                    primeiroGarfo.take();
                    segundoGarfo.take();
                    estado = Estado.COMENDO;
                    break;
                case COMENDO:
                    PenseOuComa();
                    primeiroGarfo.drop();
                    segundoGarfo.drop();
                    estado = Estado.PENSANDO;
                    break;
            }
        }
    }

    private void PenseOuComa() {
        try {
            Thread.sleep((long) Math.round(Math.random() * 5000));
        } catch (InterruptedException e) {
        }
    }

    private void imprimeEstado() {
        System.out.println("Filosofo " + id + " está " + estado);
    }
}
