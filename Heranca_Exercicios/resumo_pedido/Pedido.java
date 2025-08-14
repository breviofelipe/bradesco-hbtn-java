
public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;
    public Pedido(double percentualDesconto, ItemPedido[] itens){
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }
    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            var precoLiquido = item.getProduto().obterPrecoLiquido();
            var quantidade = item.getQuantidade();
            total += precoLiquido   * quantidade;
        }

        total -= (total * (percentualDesconto / 100));
        
        return total;
    }

    public void apresentarResumoPedido(){
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            var produto = item.getProduto();
            var precoLiquido = produto.obterPrecoLiquido();
            var quantidade = item.getQuantidade();
            double totalItem = precoLiquido * quantidade;
            totalProdutos += totalItem;
            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                produto.getClass().getSimpleName(),
                produto.getTitulo(),
                precoLiquido,
                quantidade,
                totalItem
            );
        }
        System.out.println("----------------------------");
        double desconto = totalProdutos * (percentualDesconto / 100);
        System.out.printf("DESCONTO: %.2f%n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", calcularTotal());
        System.out.println("----------------------------");
    }
}
