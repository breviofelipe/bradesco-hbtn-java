import java.util.ArrayList;

public class GestaoAlunos {
    private ArrayList<Aluno> alunos;

    public GestaoAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno novoAluno = new Aluno(nome, idade);
        alunos.add(novoAluno);
    }

    public boolean excluirAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunos.remove(aluno);
                return true;
            }
        }
        return false;
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println(aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }
    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adiciona três alunos
        gestao.adicionarAluno("Ana", 101);
        gestao.adicionarAluno("Bruno", 102);
        gestao.adicionarAluno("Carlos", 103);

        // Exibe a lista de alunos
        System.out.println("Lista de alunos:");
        gestao.listarAlunos();

        // Busca por um aluno
        System.out.println("\nBuscando aluno 'Bruno':");
        gestao.buscarAluno("Bruno");

        // Exclui um aluno
        System.out.println("\nExcluindo aluno 'Ana':");
        if (gestao.excluirAluno("Ana")) {
            System.out.println("Aluno excluído com sucesso.");
        } else {
            System.out.println("Aluno não encontrado para exclusão.");
        }

        // Tenta excluir um aluno inexistente
        System.out.println("\nTentando excluir aluno 'Daniel':");
        if (gestao.excluirAluno("Daniel")) {
            System.out.println("Aluno excluído com sucesso.");
        } else {
            System.out.println("Aluno não encontrado para exclusão.");
        }

        // Busca por outro aluno
        System.out.println("\nBuscando aluno 'Carlos':");
        gestao.buscarAluno("Carlos");

        // Exibe a lista atualizada de alunos
        System.out.println("\nLista atualizada de alunos:");
        gestao.listarAlunos();
    }
}
