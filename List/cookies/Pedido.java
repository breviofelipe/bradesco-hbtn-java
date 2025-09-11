import java.util.ArrayList;

public class Pedido {

    ArrayList<PedidoCookie> cookies;   

    public Pedido() {
        this.cookies = new ArrayList<PedidoCookie>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        cookies.add(pedidoCookie);
    }

    public Integer obterTotalCaixas() {
        Integer total = 0;
        for (PedidoCookie pedidoCookie : cookies) {
            total+= pedidoCookie.getQuantidadeCaixas();
        }
        return total;
    }

    public Integer removerSabor(String sabor) {
        Integer total = 0;
        for (int i = 0; i < cookies.size(); i++) {
            PedidoCookie pedidoCookie = cookies.get(i);
            if(pedidoCookie.getSabor().equals(sabor)){
                cookies.remove(i);
                total+= pedidoCookie.getQuantidadeCaixas();
            }
        }
        return total;
    }
}