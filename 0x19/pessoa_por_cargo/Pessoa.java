public class Pessoa {


    private String nome, cargo;
    private int codigo, idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.codigo = codigo;
        this.idade = idade;
        this.salario = salario;
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

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ %f", codigo, nome, cargo, idade, salario);
    }
}
