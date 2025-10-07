import java.util.LinkedList;

public class Fila {
    
    private final LinkedList<Integer> lista = new LinkedList<>();
        private final int capacidade;

        public Fila(int capacidade) {
            this.capacidade = capacidade;
        }

        // Adiciona item na fila; espera se a fila estiver cheia
        public synchronized void adicionar(int item) throws InterruptedException {
            while (lista.size() == capacidade) {
                // fila cheia -> aguarda espaço
                wait();
            }
            lista.addLast(item);
            System.out.printf("[%s] PRODUZIU: %d (tamanho=%d)%n",
                    Thread.currentThread().getName(), item, lista.size());
            // notifica consumidores/produtores que estão esperando
            notifyAll();
        }
        public synchronized int retirar() throws InterruptedException {
            while (lista.isEmpty()) {
                // fila vazia -> aguarda item
                wait();
            }
            int item = lista.removeFirst();
            System.out.printf("[%s] CONSUMIU: %d (tamanho=%d)%n",
                    Thread.currentThread().getName(), item, lista.size());
            // notifica produtores/consumidores que estão esperando
            notifyAll();
            return item;
        }
    }