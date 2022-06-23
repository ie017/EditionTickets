package supermarche.articles;
import java.lang.Exception;

public class ReferenceInconnueException extends Exception {
    public ReferenceInconnueException(String message){
        super(message);
    }

}
