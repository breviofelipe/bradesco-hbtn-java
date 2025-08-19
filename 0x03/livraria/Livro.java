import exceptions.AutorInvalidoException;
import exceptions.LivroInvalidoException;

public class Livro {

    private String titulo, autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) throws AutorInvalidoException, LivroInvalidoException {
        var nomes = autor.split(" ");
        if(nomes.length < 2){
            throw new AutorInvalidoException("Nome de autor invalido");
        }
        if(titulo.length() < 3){
            throw new LivroInvalidoException("Titulo de livro invalido");
        }
        if(preco <= 0){
            throw new LivroInvalidoException("Preco de livro invalido");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTitulo() {
       return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
       return preco;
    }

    public void setAutor(String autor) throws AutorInvalidoException{
        this.autor = autor;
    }

    public void setTitulo(String titulo) throws LivroInvalidoException{
        this.titulo = titulo;
    }

    public void setPreco(double preco) throws LivroInvalidoException{
        this.preco = preco;
    }

}