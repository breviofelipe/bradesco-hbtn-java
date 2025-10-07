public class Consumidor extends Thread {
    private Fila fila;


    public Consumidor(Fila fila, String nome) {
        super(nome);
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                fila.retirar();
                // simula processamento
                Thread.sleep(500);
                // processamento finalizado (já imprimimos ao retirar)
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(getName() + " finalizando.");
    }
}