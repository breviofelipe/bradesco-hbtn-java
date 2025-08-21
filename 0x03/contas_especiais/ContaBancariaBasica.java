import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao; 
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    public String getNumeracao(){
        return numeracao;
    }
    public double getSaldo(){
        return saldo;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if( valor <= 0 ){
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if( valor <= 0 ){
            throw new OperacaoInvalidaException("Valor para saque deve ser maior que 0");
        } else if (saldo < valor) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        } else {
            this.saldo -= valor;
        }
    }

    public void aplicarAtualizacaoMensal() {
        double taxaJuros = calcularJurosMensal() / 100;
        double tarifa = calcularTarifaMensal();
        this.saldo = saldo - tarifa + (saldo * taxaJuros);
    }

    double calcularTarifaMensal() {
        double tarifa = saldo > 100 ? 10.00 : (saldo * 0.1);
        return tarifa;
     }
    double calcularJurosMensal() {
        double jurosMensal = saldo < 0 ? 0 : (taxaJurosAnual / 12);
        return jurosMensal;
    }
}
