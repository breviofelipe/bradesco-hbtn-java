import java.util.Scanner;


public class ArrayExercicio {

    public static void main(String[] args) {
        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);


        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;


        // Preenchendo o array com números fornecidos pelo usuário
        // Utilize scanner.nextInt(); para receber o numero digitado
        System.out.println("Digite 10 números inteiros:");


        for (int i = 0; i < tamanhoArray; i++) {
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
            if (numeros[i] > maiorNumero) {
                maiorNumero = numeros[i];
            }
        }

        // Exibindo o array
        System.out.print("Números digitados: ");
        for (int i = 0; i < tamanhoArray; i++) {
            System.out.print(numeros[i]);
            if (i < tamanhoArray - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Exibindo a soma
        System.out.println("Soma dos números: " + soma);

        // Exibindo o maior número
        System.out.println("Maior número: " + maiorNumero);
        // Exibindo os resultados

        // Fechando o scanner
        scanner.close();
    }
}