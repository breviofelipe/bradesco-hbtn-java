public class PersonagemGame {
    private String nome;
    private int saudeAtual;
    private String status;

    public PersonagemGame(int saudeAtual, String nome) {
        setSaudeAtual(saudeAtual);
        this.nome = nome;

    }
    public void setNome(String nome){
        if(nome != null && !nome.isBlank()){
            this.nome = nome;
        }
    }
    public String getNome(){
        return this.nome;
    }

    public void setSaudeAtual(int saudeAtual){
        this.saudeAtual = saudeAtual;
        if(saudeAtual > 0){
            status = "vivo";
        } else {
            status = "morto";
        }
    }

    public int getSaudeAtual(){
        return this.saudeAtual;
    }

    public void tomarDano(int quantidadeDeDano){
        var saude = this.saudeAtual - quantidadeDeDano;
        this.saudeAtual = this.saudeAtual - quantidadeDeDano;
        if(saude < 0){
            saude = 0;
        }
        setSaudeAtual(saude);
    }

    public void receberCura(int quantidadeDeCura) {
        var saude = this.saudeAtual + quantidadeDeCura;
        if(saude > 100){
            saude = 100;
        }
        setSaudeAtual(saude);
    }

    
    public String getStatus(){
        return this.status;
    }

}
