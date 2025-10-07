import java.util.Random;

public class Produtor extends Thread {

    private Fila fila;
    private final Random random = new Random();

    public Produtor(Fila fila, String nome) {
        super(nome); 
        this.fila = fila;
    }

   @Override
   public void run() {
       try {
           while (!isInterrupted()) {
               int valor = random.nextInt(100) + 1; // 1..100
               fila.adicionar(valor);
               Thread.sleep(1000); // gera a cada 1 segundo
           }
       } catch (InterruptedException e) {
           // thread foi interrompida -> encerra
           Thread.currentThread().interrupt();
       }
       System.out.println(getName() + " finalizando.");
   }

}