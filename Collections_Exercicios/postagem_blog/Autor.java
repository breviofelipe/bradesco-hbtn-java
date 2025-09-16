public class Autor implements Comparable<Autor> {
    private String nome;
    private String sobrenome;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public int compareTo(Autor autor) {
        int sobrenomeComparison = this.sobrenome.compareTo(autor.sobrenome);
        if (sobrenomeComparison != 0) {
            return sobrenomeComparison;
        }
        return this.nome.compareTo(autor.nome);
    }

}
