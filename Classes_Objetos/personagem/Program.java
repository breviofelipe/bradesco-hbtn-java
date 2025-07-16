package Classes_Objetos.personagem;
import Classes_Objetos.personagem.PersonagemGame;
public class Program {
    public static void main(String[] args) {
        PersonagemGame personagem1 = new PersonagemGame();
        PersonagemGame personagem2 = new PersonagemGame();

        personagem1.nome = "Sonic";
        personagem1.saudeAtual= 10;

        personagem2.nome = "Mario";
        personagem2.saudeAtual = 100;
        System.out.println("Nome: " + personagem1.nome + " - Saúde: " + personagem1.saudeAtual);
        System.out.println("Nome: " + personagem2.nome + " - Saúde: " + personagem2.saudeAtual);
    }
}
