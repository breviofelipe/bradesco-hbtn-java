import java.util.HashMap;
import java.util.Map;

public class ArmazemDeEletronico extends Armazem<Eletronico>{
    private Map<String, Eletronico> armazem = new HashMap<>();
    public void adicionarAoInventario(String nome, Eletronico eletronico) {
       armazem.put(nome, eletronico);
    }

    @Override
    public Eletronico obterDoInventario(String nome) {
        return armazem.get(nome);
    }
}
