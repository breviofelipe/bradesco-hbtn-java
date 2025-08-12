public class Livro implements Produto{

    private int paginas, edicao;
    private String autor;

    @Override
    public double obterPrecoLiquido(){

    }

    public Livro(String titulo, int ano, String pais, double precoBruto, int paginas, String autor, int edicao){
        super(titulo, ano, pais, precoBruto);
        this.paginas = paginas;
        this.autor = autor;
        this.autor = autor;
    }
}
