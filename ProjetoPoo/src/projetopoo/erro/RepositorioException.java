package projetopoo.erro;

/**
 *
 * @author Tito
 */
public class RepositorioException extends Exception {
    public RepositorioException(){
        super();
    }
    
    public RepositorioException(Exception e){
        super(e);
    }
    
    public RepositorioException(String x){
        super(x);
    }
    
}
