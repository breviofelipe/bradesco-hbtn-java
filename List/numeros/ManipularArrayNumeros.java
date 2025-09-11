import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, Integer numero){
        Integer result = -1;
        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i) == numero)
                result = i;
        }
        return result;
    }

    public static void adicionarNumero(List<Integer> numeros, Integer numero) {
        if(numeros.contains(numero))
            throw new RuntimeException("Numero jah contido na lista");
        numeros.add(numero);
    }

    public static void removerNumero(List<Integer> numeros, Integer numero) {
        if(!numeros.remove(numero))
            throw new RuntimeException("Numero nao encontrado na lista");
    }

    public static void substituirNumero(List<Integer> numeros, Integer numeroSubstituir, Integer numeroSubstituto) {
        int index = buscarPosicaoNumero(numeros, numeroSubstituir);
        if(index >= 0)
            numeros.set(index, numeroSubstituto);        
        else numeros.add(numeroSubstituto);
    }
}