package excepciones;

public class ClienteExisteException extends Exception {
    public ClienteExisteException(String msj){
        super(msj);
    }
}
