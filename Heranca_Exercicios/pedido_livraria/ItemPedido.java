import produtos.Produto;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    
    ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
