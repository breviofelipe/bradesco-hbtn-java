import java.util.ArrayList;
import java.util.List;

public class Pedido {

    List<PedidoCookie> pedidos;   

    public Pedido() {
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        pedidos.add(pedidoCookie);
    }

    public Integer obterTotalCaixas() {
        Integer total = 0;
        for (PedidoCookie pedidoCookie : pedidos) {
            total+= pedidoCookie.getQuantidadeCaixas();
        }
        return total;
    }

    public Integer removerSabor(String sabor) {
        Integer total = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            PedidoCookie pedidoCookie = pedidos.get(i);
            if(pedidoCookie.getSabor().equals(sabor)){
                pedidos.remove(i);
                total+= pedidoCookie.getQuantidadeCaixas();
            }
        }
        return total;
    }
}