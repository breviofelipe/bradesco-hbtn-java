public class PersonagemGame {
    private String nome;
    private int saudeAtual;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setSaudeAtual(int saudeAtual){
        this.saudeAtual = saudeAtual;
    }

    public int getSaudeAtual(){
        return this.saudeAtual;
    }

    public void tomarDano(int dano){
        this.saudeAtual = this.saudeAtual - dano;
        if(saudeAtual < 0){
            this.saudeAtual = 0;
        }
    }

    public void receberCura(int cura) {
        this.saudeAtual = this.saudeAtual + cura;
        if(saudeAtual > 100){
            this.saudeAtual = 100;
        }
    }
}
