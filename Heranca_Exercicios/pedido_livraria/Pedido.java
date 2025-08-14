
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
}
