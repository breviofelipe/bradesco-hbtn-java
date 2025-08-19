public class LivroEdicaoOuro extends Livro{

    public LivroEdicaoOuro(String string, String string2, double d) {
        super(string, string2, d);
    }
    

    public double getPreco() {
        return super.getPreco() + (super.getPreco() * 0.3);
     }
}
