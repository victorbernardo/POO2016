package projetopoo.erro;

/**
 *
 * @author Tito
 */
public class ConexaoException extends Exception {
    public ConexaoException(){
        super();
    }
    
    public ConexaoException(Exception e){
        super(e);
    }
    
    public ConexaoException(String x){
        super(x);
    }
    
}
