public class Dvd implements Produto{
    private String diretor, genero;
    private int duracao;

    @Override
    public double obterPrecoLiquido(){

    }

    Dvd(String titulo, int ano, String pais, double precoBruto, String diretor, String genero, int duracao){
        super(titulo, ano, pais, precoBruto);
        this.diretor = diretor;
        this.genero = genero;
        this.duracao = duracao;

    }
}