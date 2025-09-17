public class Produto {
    private String nome;
    private Double preco;
    private Double percentualMarkup = 10.0;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPercentualMarkup() {
        return percentualMarkup;
    }

    public java.util.function.Supplier<Double> precoComMarkup = () -> preco + (preco * percentualMarkup / 100);

    public java.util.function.Consumer<Double> atualizarMarkup = novoMarkup -> this.percentualMarkup = novoMarkup;
}
