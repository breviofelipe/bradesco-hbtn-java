package exceptions;

public class AutorInvalidoException extends Exception{
    private String message;

    public AutorInvalidoException (String s) {
        super(s);
        message = s;
    }

    public String getMessage(){
        return message;
    }
    
}
