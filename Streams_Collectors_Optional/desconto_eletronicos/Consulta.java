import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream()
                .filter(produto -> produto.getCategoria() == CategoriaProduto.LIVRO)
                .collect(Collectors.toList());
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream().max(Comparator.comparing(Produto::getPreco))
                .orElse(null);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, int i) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() >= i)
                .collect(Collectors.toList());
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedido3) {
        return pedido3.stream()
                .filter(pedido -> pedido.getProdutos().stream()
                        .anyMatch(produto -> produto.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {

        return produtos.stream()
                .map(produto -> {
                    if (produto.getCategoria() == CategoriaProduto.ELETRONICO) {
                        double novoPreco = produto.getPreco() * 0.85;
                        return new Produto(produto.getCodigo(), produto.getNome(), produto.getCategoria(), novoPreco);
                    }
                    return produto;
                })
                .collect(Collectors.toList());
    }
}
