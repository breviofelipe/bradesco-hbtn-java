import java.util.List;
import java.util.Locale;

public class Pessoa implements Comparable<Pessoa>{


    private String nome, cargo;
    private int codigo, idade;
    private double salario;
    private List<String> hobbies;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.nome = nome;
        this.cargo = cargo;
        this.codigo = codigo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        Locale brasil = new Locale("pt", "BR");
        return String.format(brasil,"[%d] %s %s %d R$ %f", codigo, nome, cargo, idade, salario);
    }


    public int compareTo(Pessoa outra) {
        return this.nome.compareToIgnoreCase(outra.getNome());
    }
}
