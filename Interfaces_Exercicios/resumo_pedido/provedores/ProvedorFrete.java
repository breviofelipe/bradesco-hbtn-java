package provedores;

public abstract class ProvedorFrete {
    
    abstract public Frete calcularFrete(double peso, double valor);
    abstract public TipoProvedorFrete obterTipoProvedorFrete();
}
