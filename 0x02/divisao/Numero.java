public class Numero {
    public static void dividir(int a, int b){

        var result = 0;
        try {
            result =  a / b;
        } catch (Exception e) {
            
        } finally {
            if(b == 0){
                System.out.println("Nao eh possivel dividir por zero");
            } 
            System.out.printf("%d / %d = %d", a, b, result);
        }
    }
}