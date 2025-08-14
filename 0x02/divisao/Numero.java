public class Numero {
    public static void dividir(int a, int b){

        var result = 0;
        try {
            result =  a / b;
        } catch (Exception e) {
            System.out.println("Nao eh possivel dividir por zero");
        } finally {
            System.out.printf("%d / %d = %d \n", a, b, result);
        }


    }
}