import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> todasPessoas) {

        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toCollection(TreeSet::new)
                ));
    }

    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> todasPessoas) {
        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,       // agrupa por cargo
                        Collectors.counting()   // conta as pessoas de cada cargo
                ));
    }

    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> todasPessoas) {

        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo, // primeiro agrupamento: cargo
                        Collectors.groupingBy(
                                Pessoa::getIdade, // segundo agrupamento: idade
                                Collectors.counting() // contagem de pessoas com aquele cargo e idade
                        )
                ));
    }
}
