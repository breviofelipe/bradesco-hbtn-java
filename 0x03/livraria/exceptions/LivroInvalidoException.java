package exceptions;

public class LivroInvalidoException extends Exception{
    private String message;

    public LivroInvalidoException (String s) {
        super(s);
        message = s;
    }

    public String getMessage(){
        return message;
    }
}
