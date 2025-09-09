public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes = new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }
    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }
    public void buscaBinaria(String nome){
        System.out.printf("Procurando o nome: \"%s\"", nome);
        System.out.println();
        var result = buscaBinaria(nomes, nome);
        if(result > 0){
            System.out.printf("Nome %s encontrado na posição %d", nome, result);
            System.out.println();
        }
    }
    private int buscaBinaria(String[] arr, String nome) {
        int inicio = 0;
        int fim = arr.length - 1;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            System.out.println("Passando pelo indice: "+ meio);
            int comparacao = arr[meio].compareTo(nome);
            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));
    }   
}
