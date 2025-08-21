import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            String line;
            System.out.println("Digite linhas de texto (digite 'sair' para finalizar):");
            while (true) {
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("sair")) {
                    break;
                }
                writer.println(line);
            }
            System.out.println("Arquivo '" + fileName + "' criado e conteúdo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
        scanner.close();
    }
}