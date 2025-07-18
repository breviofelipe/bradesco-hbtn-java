public class Gerente extends Empregado{

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento){

        if( departamento.alcancouMeta() ){
            var bonus = getSalarioFixo() * 0.2;
            var diff = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
                        
            return bonus + diff * 0.01;
        } else {
            return 0;
        }
    }

}
