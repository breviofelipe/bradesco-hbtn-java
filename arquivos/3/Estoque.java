
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private final String arquivo;

    public Estoque (String arquivo){
        this.arquivo = arquivo;
    }

    private List<Produto> lerProdutos() {
        List<Produto> produtos = new ArrayList<>();
         try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 3) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    int quantidade = Integer.parseInt(partes[2]);
                    double preco = Double.parseDouble(partes[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException e) {
            // Arquivo não encontrado ou erro de leitura, retorna lista vazia
        }
        return produtos;
    }

    private void salvarProdutos(List<Produto> produtos) {
        try (FileWriter fw = new FileWriter(arquivo, false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Produto p : produtos) {
                bw.write(p.getId() + "," + p.getNome() + "," + p.getQuantidade() + "," + p.getPreco());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    private void adicionarProduto(Produto produto) {
        List<Produto> produtos = lerProdutos();
        produto.setId(produtos.size()+1);
        produtos.add(produto);
        salvarProdutos(produtos);
    }

    public void excluirProduto(int id) {
        List<Produto> produtos = lerProdutos();
        produtos.removeIf(p -> p.getId() == id);
        salvarProdutos(produtos);
    }

    public void exibirEstoque() {
        List<Produto> produtos = lerProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        List<Produto> produtos = lerProdutos();
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                break;
            }
        }
        salvarProdutos(produtos);
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        adicionarProduto(new Produto(0, nome, quantidade, preco));
    }

}