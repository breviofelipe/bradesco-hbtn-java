import java.util.HashMap;
import java.util.Map;

public class ArmazemDeComida extends Armazem<Comida>{

    private Map<String, Comida> armazem = new HashMap<>();


    @Override
    public void adicionarAoInventario(String nome, Comida comida) {
        armazem.put(nome, comida);
    }

    @Override
    public Comida obterDoInventario(String nome) {
        return armazem.get(nome);
    }
}
