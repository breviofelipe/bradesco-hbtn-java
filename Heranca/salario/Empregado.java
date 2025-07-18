public class Empregado {
    private double salarioFixo;

    public double getSalarioFixo(){
        return this.salarioFixo;
    }

    public Empregado (double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }
    double calcularBonus(Departamento departamento){

        if( departamento.alcancouMeta() ){
            return (salarioFixo * 0.1);
        } else {
            return 0;
        }
    }

    double calcularSalarioTotal(Departamento departamento) {
        return salarioFixo + calcularBonus(departamento);
    }
}
