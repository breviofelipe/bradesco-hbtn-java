public class SistemaFilas {
    public static void main(String[] args) throws InterruptedException{
        Fila fila = new Fila(10);
        // Criar e iniciar as threads do produtor e consumidor
        Produtor p1 = new Produtor(fila, "Produtor-1");
        Produtor p2 = new Produtor(fila, "Produtor-2");
        Consumidor c1 = new Consumidor(fila, "Consumidor-1");
        Consumidor c2 = new Consumidor(fila, "Consumidor-2");
        // inicia threads
        p1.start();
        p2.start();
        c1.start();
        c2.start();

        // executa por 20 segundos
        Thread.sleep(20_000);

        // solicita parada graciosa
        System.out.println("Solicitando parada das threads...");
        p1.interrupt();
        p2.interrupt();
        c1.interrupt();
        c2.interrupt();

        // aguarda término (com timeout para não travar indefinidamente)
        p1.join(2000);
        p2.join(2000);
        c1.join(2000);
        c2.join(2000);

        System.out.println("Encerrando aplicação.");
        System.exit(0);
    }

}
